package com.github.flickr;

import com.github.commons.ProviderRequestGenerator;
import com.github.commons.Request;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FlickrRequestGenerator implements ProviderRequestGenerator {

    private final String flickrBaseUrl;

    private final String apiKey;

    public FlickrRequestGenerator(String apiKey, String flickrBaseUrl) {
        this.apiKey = apiKey;
        this.flickrBaseUrl = flickrBaseUrl;

    }

    @Override
    public HttpRequestBase createHttpRequest(Request request) {
        String url = request.createServiceUrl(flickrBaseUrl);

        if (!url.contains("?")) {
            url = url.concat("?");
        }

        Map<String, Object> parameters = request.buildParameters();
        parameters.put("api_key", apiKey);

        List<NameValuePair> params = new LinkedList<NameValuePair>();

        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            params.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
        }

        String paramString = URLEncodedUtils.format(params, "utf-8");

        url += paramString;
        return new HttpGet(url);
    }


    @Override
    public void setRequestParameters(HttpRequestBase httpRequest, Request request) {

    }

    @Override
    public String validateResponse(String response) {
        return response.substring(0, response.length() - 1).replace("jsonFlickrApi(", "");
    }
}
