package com.github.facebook;

import com.github.commons.Builder;

/**
 * User: Wursteisen David
 * Date: 22/04/12
 * Time: 17:59
 */
public class FacebookBuilder extends Builder<Facebook> {

    public FacebookBuilder() {
        super("facebook.apikey", "facebook.secret");
    }

    @Override
    public Facebook build() {
        return new Facebook(getApiKey(), getSecret(), "http://localhost:9000");
    }
}
