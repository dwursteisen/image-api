package com.github.imgur.api.commons;

import com.github.commons.Response;

/**
 * User: Wursteisen David
 * Date: 27/02/12
 * Time: 23:20
 */
public abstract class ImgurResponse implements Response {
    private String raw;

    @Override
    public void setRawResponse(String rawResponse) {
        this.raw = rawResponse;
    }

    @Override
    public String toString() {
        return raw;
    }
}
