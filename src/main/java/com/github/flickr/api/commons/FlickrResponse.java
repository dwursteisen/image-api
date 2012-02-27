package com.github.flickr.api.commons;

import com.github.commons.Response;

/**
 * User: Wursteisen David
 * Date: 27/02/12
 * Time: 23:16
 */
public abstract class FlickrResponse implements Response {

    private String raw;

    @Override
    public void setRawResponse(String rawResponse) {
        this.raw = rawResponse;
    }

    @Override
    public String toString() {
        return this.raw;
    }
}
