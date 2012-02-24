package com.github.imgur.api.account;

import com.github.commons.ProviderRequestGenerator;
import com.github.commons.RequestManager;

/**
 * User: Wursteisen David
 * Date: 24/02/12
 * Time: 22:54
 */
public class AccountManager extends RequestManager<AccountRequest, AccountResponse> {
    public AccountManager(ProviderRequestGenerator provider) {
        super(AccountResponse.class, provider);
    }
}
