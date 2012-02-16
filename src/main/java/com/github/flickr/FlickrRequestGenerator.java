package com.github.flickr;

import com.github.commons.ProviderRequestGenerator;
import com.github.commons.Request;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.params.BasicHttpParams;

import java.util.Map;

public class FlickrRequestGenerator implements ProviderRequestGenerator{

    private final String flickrBaseUrl;

    private final String apiKey;

    public FlickrRequestGenerator(String apiKey, String flickrBaseUrl) {
        this.apiKey = apiKey;
        this.flickrBaseUrl = flickrBaseUrl;

    }

    @Override
    public HttpRequestBase createHttpRequest(Request request) {
        return new HttpGet(request.createServiceUrl(flickrBaseUrl));
    }


    @Override
    public void setRequestParameters(HttpRequestBase httpRequest, Request request) {
        Map<String, Object> parameters = request.buildParameters();
        parameters.put("api_key", apiKey);

        BasicHttpParams httpParameters = new BasicHttpParams();
        for (Map.Entry<String, Object> params : parameters.entrySet()) {
             httpParameters.setParameter(params.getKey(), params.getValue());
        }

        httpRequest.setParams(httpParameters);
    }
}
