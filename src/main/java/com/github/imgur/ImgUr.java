package com.github.imgur;

import com.github.commons.OAuthSupport;
import com.github.commons.RequestManager;
import com.github.imgur.api.account.AccountRequest;
import com.github.imgur.api.account.AccountResponse;
import com.github.imgur.api.image.ImageRequest;
import com.github.imgur.api.image.ImageResponse;
import com.github.imgur.api.stats.StatsRequest;
import com.github.imgur.api.stats.StatsResponse;
import com.github.imgur.api.upload.UploadRequest;
import com.github.imgur.api.upload.UploadResponse;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.ImgUrApi;
import org.scribe.oauth.OAuthService;

import java.io.IOException;

/**
 * User: Wursteisen David
 * Date: 22/02/12
 * Time: 21:11
 */
public class ImgUr extends OAuthSupport {
    private final ImgUrRequestGenerator requestGenerator;
    private final RequestManager requestManager;


    public ImgUr(String apiKey) {
        this(apiKey, (OAuthService) null);
    }

    public ImgUr(String apiKey, OAuthService oauth) {
        super(oauth);
        requestGenerator = new ImgUrRequestGenerator(apiKey, oauth);
        requestManager = new RequestManager(requestGenerator);
    }

    public ImgUr(String apiKey, String secret) {
        this(apiKey, new ServiceBuilder().provider(ImgUrApi.class)
                .apiKey(apiKey)
                .apiSecret(secret)
                .build());
    }

    public AccountResponse call(AccountRequest request) throws IOException {
        return requestManager.call(request, AccountResponse.class);
    }

    public ImageResponse call(ImageRequest request) throws IOException {
        return requestManager.call(request, ImageResponse.class);
    }

    public StatsResponse call(StatsRequest request) throws IOException {
        return requestManager.call(request, StatsResponse.class);
    }

    public UploadResponse call(UploadRequest request) throws IOException {
        return requestManager.call(request, UploadResponse.class);
    }

}
