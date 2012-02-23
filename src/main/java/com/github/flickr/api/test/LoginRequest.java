package com.github.flickr.api.test;

import com.github.flickr.api.commons.FlickrRequest;

import java.util.Map;

public class LoginRequest extends FlickrRequest {
    @Override
    public Map<String, Object> buildParameters() {
        return null;
    }

    @Override
    public boolean isOAuth() {
        return true;
    }
}
