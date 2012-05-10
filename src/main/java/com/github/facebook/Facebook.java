package com.github.facebook;

import com.github.commons.OAuthSupport;
import com.github.commons.RequestManager;
import com.github.commons.RequestProvider;
import com.github.facebook.api.albums.AlbumsRequest;
import com.github.facebook.api.albums.AlbumsResponse;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.FacebookApi;

import java.io.IOException;

/**
 * User: Wursteisen David                                  F
 * Date: 22/04/12
 * Time: 16:34
 */
public class Facebook extends OAuthSupport {
    private final RequestManager requestManager;

    public Facebook(final String apiKey, final String secret, final String callbackUrl) {
        super(new ServiceBuilder()
                .provider(FacebookApi.class)
                .callback(callbackUrl)
                .apiKey(apiKey)
                .apiSecret(secret).build());
        RequestProvider provider = new FacebookRequestProvider(oauth);
        requestManager = new RequestManager(provider);
    }

    public AlbumsResponse call(final AlbumsRequest request) throws IOException {
        return requestManager.call(request, AlbumsResponse.class);
    }
}
