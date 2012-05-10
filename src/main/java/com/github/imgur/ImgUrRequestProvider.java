package com.github.imgur;

import com.github.commons.Request;
import com.github.commons.RequestProvider;
import com.github.imgur.api.commons.ImgUrRequest;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import java.util.Map;

public class ImgUrRequestProvider implements RequestProvider {

    private static final String IMGUR_BASE_URL = "http://api.imgur.com/2/";

    private final String apiKey;
    private final OAuthService oauth;

    public ImgUrRequestProvider(String apiKey) {
        this(apiKey, null);
    }

    public ImgUrRequestProvider(String apiKey, OAuthService oauth) {
        this.apiKey = apiKey;
        this.oauth = oauth;
    }

    @Override
    public OAuthRequest createHttpRequest(Request r) {
        ImgUrRequest request = (ImgUrRequest) r;
        return new OAuthRequest(request.getVerb(), request.requestUrl(IMGUR_BASE_URL));
    }

    @Override
    public void addRequestParameters(OAuthRequest httpRequest, Request r) {
        ImgUrRequest request = (ImgUrRequest) r;

        Map<String, Object> params = request.buildParameters();
        Verb verb = request.getVerb();
        for (Map.Entry<String, Object> p : params.entrySet()) {
            if (verb == Verb.GET) {
                httpRequest.addQuerystringParameter(p.getKey(), "" + p.getValue());
            } else {
                httpRequest.addBodyParameter(p.getKey(), "" + p.getValue());
            }
        }
        if (!request.isOAuth() && apiKey != null) {
            if (verb == Verb.GET) {
                httpRequest.addQuerystringParameter("key", apiKey);
            } else {
                httpRequest.addBodyParameter("key", apiKey);
            }
        }

    }

    @Override
    public String jsonUpdater(String response) {
        return response;
    }

    @Override
    public void signRequest(OAuthRequest httpRequest, Request r) {
        ImgUrRequest request = (ImgUrRequest) r;
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
