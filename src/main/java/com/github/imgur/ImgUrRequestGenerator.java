package com.github.imgur;

import com.github.commons.ProviderRequestGenerator;
import com.github.commons.Request;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Verb;

public class ImgUrRequestGenerator implements ProviderRequestGenerator {

    @Override
    public OAuthRequest createHttpRequest(Request request) {
        return new OAuthRequest(Verb.POST, "");
    }

    @Override
    public void addRequestParameters(OAuthRequest httpRequest, Request request) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String validateResponse(String response) {
        return response;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
