/*
 * Copyright (C) 2010 David Wursteisen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.imgur.request;

import com.google.gson.Gson;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RequestManager<REQUEST extends Request, RESPONSE extends Response> {

    private static final String API_KEY = "e67bb2d5ceb42e43f8f7fc38e7ca7376";
    private static final String IMGUR_STATS_URL = "http://api.imgur.com/2/";
    private final Class<RESPONSE> clazz;
    private final Gson gson = new Gson();

    public RequestManager(Class<RESPONSE> clazz) {
        this.clazz = clazz;

    }

    public RESPONSE call(REQUEST request) throws IOException {

        final HttpClient httpclient = new DefaultHttpClient();
        final String serviceUrl = request.createServiceUrl(IMGUR_STATS_URL) + ".json";

        try {
            HttpPost httpRequest = new HttpPost(serviceUrl);
            List<NameValuePair> parameters = buildParameters(request);
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters, "UTF-8");

            httpRequest.setEntity(entity);

            // Create a response handler
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpRequest, responseHandler);

            return gson.fromJson(responseBody, clazz);
        } catch (HttpResponseException ex) {
            throw new IOException("Oooopppss nothing found at the URL " + serviceUrl, ex);
        } finally {
            httpclient.getConnectionManager().shutdown();
        }

    }


    List<NameValuePair> buildParameters(REQUEST request) {

        final List<NameValuePair> result = new ArrayList();
        result.add(new BasicNameValuePair("key", API_KEY));

        final Map<String, Object> mapParams = request.buildParameters();
        for (Map.Entry<String, Object> entry : mapParams.entrySet()) {
            result.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
        }
        return result;
    }
}
