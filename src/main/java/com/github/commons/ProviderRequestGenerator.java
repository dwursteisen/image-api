package com.github.commons;

import org.scribe.model.OAuthRequest;

public interface ProviderRequestGenerator<REQUEST extends Request> {

    OAuthRequest createHttpRequest(REQUEST request);

    void addRequestParameters(OAuthRequest httpRequest, REQUEST request);

    String validateResponse(String response);

    void signRequest(OAuthRequest httpRequest, REQUEST request);

}
