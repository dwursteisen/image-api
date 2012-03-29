package com.github.flickr.api.photos.licenses;

import com.github.commons.Response;
import com.github.flickr.Flickr;
import com.github.flickr.api.commons.FlickrRequest;

import java.io.IOException;
import java.util.Map;

/**
 * User: Wursteisen David
 * Date: 30/03/12
 * Time: 00:05
 */
public class GetInfoRequest extends FlickrRequest {
    @Override
    public Response call(Flickr flickr) throws IOException {
        return flickr.call(this);
    }

    @Override
    public Map<String, Object> buildParameters() {
        return emptyParameters("flickr.photos.licenses.getInfo");
    }

    @Override
    public boolean isOAuth() {
        return false;
    }
}
