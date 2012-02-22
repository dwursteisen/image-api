package com.github.flickr;

import com.github.commons.ProviderRequestGenerator;
import com.github.flickr.api.commons.FlickrRequest;
import org.apache.log4j.Logger;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Verb;

import java.util.Map;

public class FlickrRequestGenerator implements ProviderRequestGenerator<FlickrRequest> {


    private final static Logger LOG = Logger.getLogger(FlickrRequestGenerator.class);

    private static final String FLICKR_BASE_URL = "http://api.flickr.com/services/rest/";

    private final String apiKey;


    public FlickrRequestGenerator(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public OAuthRequest createHttpRequest(FlickrRequest request) {
        return new OAuthRequest(Verb.GET, FLICKR_BASE_URL);
    }

    @Override
    public void addRequestParameters(OAuthRequest httpRequest, FlickrRequest request) {
        Map<String, Object> params = request.buildParameters();
        for (Map.Entry<String, Object> p : params.entrySet()) {
            httpRequest.addQuerystringParameter(p.getKey(), "" + p.getValue());
        }
        httpRequest.addQuerystringParameter("format", "json");
        httpRequest.addQuerystringParameter("api_key", apiKey);
    }

    @Override
    public String validateResponse(String response) {
        String json = response.substring(0, response.length() - 1).replace("jsonFlickrApi(", "");
        if (LOG.isDebugEnabled()) {
            LOG.debug("JSon received from flickr : " + json);
        }
        return json;
    }
}
