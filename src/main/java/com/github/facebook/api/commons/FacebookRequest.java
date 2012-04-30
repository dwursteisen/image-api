package com.github.facebook.api.commons;

import com.github.commons.Request;
import org.scribe.model.Token;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Wursteisen David
 * Date: 22/04/12
 * Time: 17:42
 */
public abstract class FacebookRequest implements Request {

    public static final String ME_AS_USER_ID = "me";

    private String userId = ME_AS_USER_ID;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setMeAsUserId() {
        setUserId(ME_AS_USER_ID);
    }

    public abstract String requestUrl(String baseUrl);

    private Token accessToken;

    public Token getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(Token accessToken) {
        this.accessToken = accessToken;
    }


    protected Map<String, Object> emtpyParameters() {
        return new HashMap<String, Object>();
    }

    @Override
    public Map<String, Object> buildParameters() {
        return emtpyParameters();
    }

    @Override
    public boolean isOAuth() {
        return true;
    }
}
