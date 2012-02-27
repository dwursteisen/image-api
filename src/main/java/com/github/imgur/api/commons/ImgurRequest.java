package com.github.imgur.api.commons;

import com.github.commons.Request;
import org.scribe.model.Token;
import org.scribe.model.Verb;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Wursteisen David
 * Date: 22/02/12
 * Time: 21:43
 */
public abstract class ImgurRequest implements Request {

    private Token accessToken;

    private String raw;

    public Token getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(Token accessToken) {
        this.accessToken = accessToken;
    }

    public abstract String requestUrl(String baseUrl);

    public Verb getVerb() {
        return Verb.POST;
    }

    public Map<String, Object> emptyParameters() {
        return new HashMap<String, Object>();
    }

    public void setRawResponse(String r) {
        this.raw = r;
    }
}
