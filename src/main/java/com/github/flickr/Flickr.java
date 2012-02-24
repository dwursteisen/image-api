package com.github.flickr;

import com.github.commons.OAuthSupport;
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

public class Flickr extends OAuthSupport {


    private final ProviderRequestGenerator<? extends FlickrRequest> generator;

    public Flickr(final String apiKey, final String secret) {
        this(apiKey, new ServiceBuilder().provider(FlickrApi.class).apiKey(apiKey).apiSecret(secret).build());
    }

    public Flickr(final String apiKey, final OAuthService oauthService) {
        super(oauthService);
        this.generator = new FlickrRequestGenerator(apiKey, oauth);
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
