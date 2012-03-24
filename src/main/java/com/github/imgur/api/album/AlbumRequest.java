package com.github.imgur.api.album;

import com.github.imgur.api.commons.ImgUrRequest;

import java.util.Map;

/**
 * User: Wursteisen David
 * Date: 24/03/12
 * Time: 13:58
 */
public class AlbumRequest extends ImgUrRequest {

    private final String hash;

    public AlbumRequest(final String hash) {
        this.hash = hash;
    }

    @Override
    public String requestUrl(String baseUrl) {
        return baseUrl + "album/" + hash + ".json";
    }

    @Override
    public Map<String, Object> buildParameters() {
        return emptyParameters();
    }

    @Override
    public boolean isOAuth() {
        return false;
    }
}
