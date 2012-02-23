package com.github.flickr;

import com.github.commons.Builder;

/**
 * User: Wursteisen David
 * Date: 18/02/12
 * Time: 14:34
 */
public class FlickrBuilder extends Builder<Flickr> {


    public FlickrBuilder() {
        super("flickr.apikey", "flickr.secret");
    }

    @Override
    public Flickr build() {
        return new Flickr(getApiKey(), getSecret());
    }
}
