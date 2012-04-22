package com.github.facebook.api.commons;

import com.github.commons.Response;

/**
 * User: Wursteisen David
 * Date: 22/04/12
 * Time: 17:44
 */
public class FacebookResponse implements Response {

    private String rawResponse;

    @Override
    public void setRawResponse(String rawResponse) {
        this.rawResponse = rawResponse;
    }
}
