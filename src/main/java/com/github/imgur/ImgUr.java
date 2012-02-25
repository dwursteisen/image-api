package com.github.imgur;

import com.github.commons.OAuthSupport;
import com.github.imgur.api.account.AccountManager;
import com.github.imgur.api.image.ImageManager;
import com.github.imgur.api.stats.StatsManager;
import com.github.imgur.api.upload.UploadManager;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.ImgUrApi;
import org.scribe.oauth.OAuthService;

/**
 * User: Wursteisen David
 * Date: 22/02/12
 * Time: 21:11
 */
public class ImgUr extends OAuthSupport {
    private final ImgUrRequestGenerator requestGenerator;


    public ImgUr(String apiKey) {
        this(apiKey, (OAuthService) null);
    }

    public ImgUr(String apiKey, OAuthService oauth) {
        super(oauth);
        requestGenerator = new ImgUrRequestGenerator(apiKey, oauth);
    }

    public ImgUr(String apiKey, String secret) {
        this(apiKey, new ServiceBuilder().provider(ImgUrApi.class)
                .apiKey(apiKey)
                .apiSecret(secret)
                .build());
    }

    public UploadManager upload() {
        return new UploadManager(requestGenerator);
    }

    public StatsManager stats() {
        return new StatsManager(requestGenerator);
    }

    public ImageManager image() {
        return new ImageManager(requestGenerator);
    }

    public AccountManager account() {
        return new AccountManager(requestGenerator);
    }
}
