package com.github.facebook;

import com.github.commons.Request;
import com.github.commons.RequestProvider;
import com.github.facebook.api.commons.FacebookRequest;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

/**
 * User: Wursteisen David
 * Date: 22/04/12
 * Time: 18:34
 */
public class FacebookRequestProvider implements RequestProvider {


    private static final String FACEBOOK_BASE_URL = "https://graph.facebook.com/%s";

    private OAuthService oauth;

    public FacebookRequestProvider(OAuthService oauth) {
        this.oauth = oauth;
    }

    @Override
    public OAuthRequest createHttpRequest(Request request) {
        FacebookRequest facebookRequest = (FacebookRequest) request;
        String userId = facebookRequest.getUserId();
        String baseUrl = String.format(FACEBOOK_BASE_URL, userId);
        String url = facebookRequest.requestUrl(baseUrl);
        return new OAuthRequest(Verb.GET, url);
    }

    @Override
    public void addRequestParameters(OAuthRequest httpRequest, Request request) {

    }

    @Override
    public String jsonUpdater(String response) {
        return response;
    }

    @Override
    public void signRequest(OAuthRequest httpRequest, Request r) {
        FacebookRequest request = (FacebookRequest) r;
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
