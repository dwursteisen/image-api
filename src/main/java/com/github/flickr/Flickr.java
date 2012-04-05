package com.github.flickr;

import com.github.commons.OAuthSupport;
import com.github.commons.ProviderRequestGenerator;
import com.github.commons.RequestManager;
import com.github.flickr.api.collections.GetInfoRequest;
import com.github.flickr.api.collections.GetInfoResponse;
import com.github.flickr.api.collections.GetTreeRequest;
import com.github.flickr.api.collections.GetTreeResponse;
import com.github.flickr.api.interestingness.GetListRequest;
import com.github.flickr.api.interestingness.GetListResponse;
import com.github.flickr.api.people.GetPhotosRequest;
import com.github.flickr.api.people.GetPhotosResponse;
import com.github.flickr.api.test.*;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.FlickrApi;
import org.scribe.oauth.OAuthService;

import java.io.IOException;

public class Flickr extends OAuthSupport {


    private final ProviderRequestGenerator generator;
    private final RequestManager requestManager;

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
        requestManager = new RequestManager(generator);
    }

    public GetPhotosResponse call(GetPhotosRequest request) throws IOException {
        return requestManager.call(request, GetPhotosResponse.class);
    }

    public GetListResponse call(GetListRequest request) throws IOException {
        return requestManager.call(request, GetListResponse.class);
    }

    public EchoResponse call(EchoRequest request) throws IOException {
        return requestManager.call(request, EchoResponse.class);
    }

    public LoginResponse call(LoginRequest request) throws IOException {
        return requestManager.call(request, LoginResponse.class);
    }

    public NullResponse call(NullRequest nullRequest) throws IOException {
        return requestManager.call(nullRequest, NullResponse.class);
    }

    public com.github.flickr.api.panda.GetListResponse call(com.github.flickr.api.panda.GetListRequest request) throws IOException {
        return requestManager.call(request, com.github.flickr.api.panda.GetListResponse.class);
    }

    public com.github.flickr.api.panda.GetPhotosResponse call(com.github.flickr.api.panda.GetPhotosRequest request) throws IOException {
        return requestManager.call(request, com.github.flickr.api.panda.GetPhotosResponse.class);
    }

    public GetInfoResponse call(GetInfoRequest request) throws IOException {
        return requestManager.call(request, GetInfoResponse.class);
    }

    public GetTreeResponse call(GetTreeRequest request) throws IOException {
        return requestManager.call(request, GetTreeResponse.class);
    }
}
