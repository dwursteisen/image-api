package com.github.flickr;

import com.github.commons.ProviderRequestGenerator;
import com.github.flickr.api.commons.FlickrRequest;
import com.github.flickr.api.interestingness.GetListManager;
import com.github.flickr.api.test.EchoManager;
import com.github.flickr.api.test.LoginManager;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.FlickrApi;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

public class Flickr {


    private final ProviderRequestGenerator<? extends FlickrRequest> generator;

    private final OAuthService oauth;

    public Flickr(final String apiKey) {
        this(apiKey, new ServiceBuilder().provider(FlickrApi.class).apiKey(apiKey).apiSecret("").build());
    }

    public Flickr(final String apiKey, final OAuthService oauthService) {
        this.oauth = oauthService;
        this.generator = new FlickrRequestGenerator(apiKey, oauth);
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

    public EchoManager echo() {
        return new EchoManager(generator);
    }

    public LoginManager login() {
        return new LoginManager(generator);
    }

    public GetListManager interestingness() {
        return new GetListManager(generator);
    }
}
