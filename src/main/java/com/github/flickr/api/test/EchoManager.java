package com.github.flickr.api.test;

import com.github.commons.ProviderRequestGenerator;
import com.github.commons.RequestManager;

public class EchoManager extends RequestManager<EchoRequest, EchoResponse> {

    public EchoManager(final ProviderRequestGenerator generator) {
        super(EchoResponse.class, generator);
    }
}
