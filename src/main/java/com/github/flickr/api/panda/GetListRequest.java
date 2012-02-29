package com.github.flickr.api.panda;

import com.github.commons.Response;
import com.github.flickr.Flickr;
import com.github.flickr.api.commons.FlickrRequest;

import java.io.IOException;
import java.util.Map;

/**
 * User: Wursteisen David
 * Date: 29/02/12
 * Time: 21:48
 */
public class GetListRequest extends FlickrRequest {
    @Override
    public Response call(Flickr flickr) throws IOException {
        return flickr.call(this);
    }

    @Override
    public Map<String, Object> buildParameters() {
        return emptyParameters("flickr.panda.getList");
    }

    @Override
    public boolean isOAuth() {
        return false;
    }
}
