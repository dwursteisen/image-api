package com.github.commons;

import org.scribe.model.OAuthRequest;

public interface RequestProvider {

    OAuthRequest createHttpRequest(Request request);

    void addRequestParameters(OAuthRequest httpRequest, Request request);

    String jsonUpdater(String json);

    void signRequest(OAuthRequest httpRequest, Request request);

}
