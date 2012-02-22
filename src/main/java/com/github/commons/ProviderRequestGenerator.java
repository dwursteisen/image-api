package com.github.commons;

import org.scribe.model.OAuthRequest;

public interface ProviderRequestGenerator {

    OAuthRequest createHttpRequest(Request request);

    void addRequestParameters(OAuthRequest httpRequest, Request request);

    String validateResponse(String response);


}
