package com.github.flickr;

import com.github.commons.ProviderRequestGenerator;
import com.github.flickr.api.test.EchoManager;

public class Flickr {

    private static final String FLICKR_BASE_URL = "http://api.flickr.com/services/rest/";

    private final ProviderRequestGenerator generator;

    public Flickr(final String apiKey) {
        generator = new FlickrRequestGenerator(apiKey, FLICKR_BASE_URL);
    }

    public EchoManager echo() {
        return new EchoManager(generator);
    }
}
