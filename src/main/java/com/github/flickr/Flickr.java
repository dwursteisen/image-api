package com.github.flickr;

import com.github.commons.ProviderRequestGenerator;
import com.github.flickr.api.interestingness.GetListManager;
import com.github.flickr.api.test.EchoManager;

public class Flickr {


    private final ProviderRequestGenerator generator;

    public Flickr(final String apiKey) {
        generator = new FlickrRequestGenerator(apiKey);
    }

    public EchoManager echo() {
        return new EchoManager(generator);
    }

    public GetListManager interestingness() {
        return new GetListManager(generator);
    }
}
