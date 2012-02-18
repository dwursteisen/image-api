package com.github.imgur;

import com.github.commons.ProviderRequestGenerator;
import com.github.commons.Request;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImgUrRequestGenerator implements ProviderRequestGenerator {
    @Override
    public HttpRequestBase createHttpRequest(Request request) {
        return null;
    }

    @Override
    public void setRequestParameters(HttpRequestBase httpRequest, Request request) {
        List<NameValuePair> parameters = buildParameters(request);

        UrlEncodedFormEntity entity = null;
        try {
            entity = new UrlEncodedFormEntity(parameters, "UTF-8");
            ((HttpPost) httpRequest).setEntity(entity);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

    List<NameValuePair> buildParameters(Request request) {

        final List<NameValuePair> result = new ArrayList<NameValuePair>();
        // result.add(new BasicNameValuePair("key", API_KEY));

        final Map<String, Object> mapParams = request.buildParameters();
        for (Map.Entry<String, Object> entry : mapParams.entrySet()) {
            result.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
        }
        return result;
    }

    @Override
    public String validateResponse(String response) {
        return response;
    }
}
