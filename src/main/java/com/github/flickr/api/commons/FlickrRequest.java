package com.github.flickr.api.commons;

import com.github.commons.Request;
import com.github.commons.Response;
import com.github.flickr.Flickr;
import org.scribe.model.Token;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    public Map<String, Object> emptyParameters(String method) {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("method", method);
        return params;
    }

    public abstract Response call(Flickr flickr) throws IOException;

}
