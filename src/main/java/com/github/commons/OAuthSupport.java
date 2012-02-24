package com.github.commons;

import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

/**
 * User: Wursteisen David
 * Date: 24/02/12
 * Time: 22:24
 */
public class OAuthSupport {
    protected final OAuthService oauth;

    public OAuthSupport(final OAuthService oauthService) {
        this.oauth = oauthService;
    }

    public Token getRequestToken() {
        return oauth.getRequestToken();
    }

    public String getAuthorizationUrl(Token requestToken) {
        return oauth.getAuthorizationUrl(requestToken);
    }

    public Token getAccessToken(Token requestToken, Verifier verifier) {
        return oauth.getAccessToken(requestToken, verifier);
    }
}
