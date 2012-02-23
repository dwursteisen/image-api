package com.github.flickr.api.test;

import com.github.flickr.api.commons.FlickrRequest;
import org.scribe.model.Token;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends FlickrRequest {
    
    public LoginRequest(Token accessToken) {
        setAccessToken(accessToken);
    }

    @Override
    public Map<String, Object> buildParameters() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("method", "flickr.test.login");
        return params;
    }

    @Override
    public boolean isOAuth() {
        return true;
    }
}
