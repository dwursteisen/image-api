package com.github.flickr;

import com.github.commons.OAuthSupport;
import com.github.commons.ProviderRequestGenerator;
import com.github.commons.RequestManager;
import com.github.flickr.api.interestingness.GetListRequest;
import com.github.flickr.api.interestingness.GetListResponse;
import com.github.flickr.api.people.GetPhotosRequest;
import com.github.flickr.api.people.GetPhotosResponse;
import com.github.flickr.api.test.EchoRequest;
import com.github.flickr.api.test.EchoResponse;
import com.github.flickr.api.test.LoginRequest;
import com.github.flickr.api.test.LoginResponse;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.FlickrApi;
import org.scribe.oauth.OAuthService;

import java.io.IOException;

public class Flickr extends OAuthSupport {


    private final ProviderRequestGenerator generator;

    public Flickr(final String apiKey, final String secret, final String callback) {
        this(apiKey, new ServiceBuilder().provider(FlickrApi.class)
                .callback(callback)
                .apiKey(apiKey)
                .apiSecret(secret).build());
    }

    public Flickr(final String apiKey, final String secret) {
        this(apiKey, new ServiceBuilder().provider(FlickrApi.class).apiKey(apiKey).apiSecret(secret).build());
    }

    public Flickr(final String apiKey, final OAuthService oauthService) {
        super(oauthService);
        this.generator = new FlickrRequestGenerator(apiKey, oauth);
    }

    public GetPhotosResponse call(GetPhotosRequest request) throws IOException {
        return new RequestManager(generator).call(request, GetPhotosResponse.class);
    }

    public GetListResponse call(GetListRequest request) throws IOException {
        return new RequestManager(generator).call(request, GetListResponse.class);
    }

    public EchoResponse call(EchoRequest request) throws IOException {
        return new RequestManager(generator).call(request, EchoResponse.class);
    }

    public LoginResponse call(LoginRequest request) throws IOException {
        return new RequestManager(generator).call(request, LoginResponse.class);
    }

}
