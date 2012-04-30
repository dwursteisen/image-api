package com.github.facebook.api.albums;

import com.github.facebook.api.commons.FacebookRequest;

/**
 * User: Wursteisen David
 * Date: 22/04/12
 * Time: 17:42
 */
public class AlbumsRequest extends FacebookRequest {

    @Override
    public String requestUrl(String baseUrl) {
        return baseUrl + "/albums";
    }
}
