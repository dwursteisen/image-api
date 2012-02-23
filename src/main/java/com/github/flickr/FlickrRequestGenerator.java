package com.github.flickr;

import com.github.commons.ProviderRequestGenerator;
import com.github.flickr.api.commons.FlickrRequest;
import org.apache.log4j.Logger;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import java.util.Map;

public class FlickrRequestGenerator implements ProviderRequestGenerator<FlickrRequest> {


    private final static Logger LOG = Logger.getLogger(FlickrRequestGenerator.class);

    private static final String FLICKR_BASE_URL = "http://api.flickr.com/services/rest/";

    private final String apiKey;
    private final OAuthService oauth;

    public FlickrRequestGenerator(String apiKey) {
        this(apiKey, null);
    }

    public FlickrRequestGenerator(String apikey, OAuthService oauth) {
        this.apiKey = apikey;
        this.oauth = oauth;
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

    @Override
    public void signRequest(OAuthRequest httpRequest, FlickrRequest request) {
        Token accessToken = request.getAccessToken();
        if (accessToken == null && request.isOAuth()) {
            throw new IllegalArgumentException("Oups ! You try to access to an resource "
                                               + "which need authentication, "
                                               + "and you haven't set an "
                                               + "access token on your request " + request + ". "
                                               + "Please set this token and retry.");
        }
        oauth.signRequest(accessToken, httpRequest);
    }
}
