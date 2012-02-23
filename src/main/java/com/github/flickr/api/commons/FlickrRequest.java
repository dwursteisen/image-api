package com.github.flickr.api.commons;

import com.github.commons.Request;
import org.scribe.model.Token;

/**
 * User: Wursteisen David
 * Date: 22/02/12
 * Time: 21:42
 */
public abstract class FlickrRequest implements Request {
    private Token accessToken;

    public Token getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(Token accessToken) {
        this.accessToken = accessToken;
    }
}
