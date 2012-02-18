package com.github.commons;

import org.apache.http.client.methods.HttpRequestBase;

public interface ProviderRequestGenerator {

    HttpRequestBase createHttpRequest(Request request);

    void setRequestParameters(HttpRequestBase httpRequest, Request request);

    String validateResponse(String response);
}
