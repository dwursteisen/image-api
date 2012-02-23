package com.github.flickr.api.test;

import com.github.commons.ProviderRequestGenerator;
import com.github.commons.RequestManager;

public class LoginManager extends RequestManager<LoginRequest, LoginResponse> {
    public LoginManager(ProviderRequestGenerator provider) {
        super(LoginResponse.class, provider);
    }
}
