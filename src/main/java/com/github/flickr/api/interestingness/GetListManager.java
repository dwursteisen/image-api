package com.github.flickr.api.interestingness;

import com.github.commons.ProviderRequestGenerator;
import com.github.commons.RequestManager;

/**
 * User: Wursteisen David
 * Date: 18/02/12
 * Time: 14:20
 */
public class GetListManager extends RequestManager<GetListRequest, GetListResponse> {

    public GetListManager(ProviderRequestGenerator provider) {
        super(GetListResponse.class, provider);
    }
}
