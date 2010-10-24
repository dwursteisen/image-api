/*
 * Copyright 2010 David Wursteisen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package com.github.dwursteisen.imgur.request;

import com.google.gson.Gson;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

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

        try {
            HttpPost httpRequest = new HttpPost(IMGUR_STATS_URL + request.getURI() + ".json");
            httpRequest.getParams().setParameter("key", API_KEY);


            // Create a response handler
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpRequest, responseHandler);

            return gson.fromJson(responseBody, clazz);
        } finally {
            httpclient.getConnectionManager().shutdown();
        }

    }


}
