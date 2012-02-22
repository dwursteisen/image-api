package com.github.imgur;

import com.github.commons.ProviderRequestGenerator;
import com.github.imgur.api.commons.ImgurRequest;
import org.apache.log4j.Logger;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Verb;

import java.util.Map;

public class ImgUrRequestGenerator implements ProviderRequestGenerator<ImgurRequest> {

    private final static Logger LOG = Logger.getLogger(ImgUrRequestGenerator.class);

    private static final String IMGUR_BASE_URL = "http://api.imgur.com/2/";

    private final String apiKey;

    public ImgUrRequestGenerator(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public OAuthRequest createHttpRequest(ImgurRequest request) {
        return new OAuthRequest(request.getVerb(), request.requestUrl(IMGUR_BASE_URL));
    }

    @Override
    public void addRequestParameters(OAuthRequest httpRequest, ImgurRequest request) {
        Map<String, Object> params = request.buildParameters();
        Verb verb = request.getVerb();
        for (Map.Entry<String, Object> p : params.entrySet()) {
            if (verb == Verb.GET) {
                httpRequest.addQuerystringParameter(p.getKey(), "" + p.getValue());
            } else {
                httpRequest.addBodyParameter(p.getKey(), "" + p.getValue());
            }
        }

        httpRequest.addBodyParameter("key", apiKey);

    }

    @Override
    public String validateResponse(String response) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("JSon received from imgur : " + response);
        }
        return response;
    }
}
