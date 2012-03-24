package com.github.imgur.api.account;

import com.github.imgur.api.commons.ImgUrRequest;
import org.scribe.model.Token;

import java.util.Map;

/**
 * User: Wursteisen David
 * Date: 24/02/12
 * Time: 22:27
 */
public class AccountRequest extends ImgUrRequest {
    public AccountRequest(Token accessToken) {
        setAccessToken(accessToken);
    }

    @Override
    public String requestUrl(String baseUrl) {
        return baseUrl + "account.json";
    }

    @Override
    public Map<String, Object> buildParameters() {
        return super.emptyParameters();
    }

    @Override
    public boolean isOAuth() {
        return true;
    }
}
