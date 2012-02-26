package com.github.flickr.api.people;

import com.github.commons.ProviderRequestGenerator;
import com.github.commons.RequestManager;

/**
 * User: Wursteisen David
 * Date: 26/02/12
 * Time: 15:43
 */
public class GetPhotosManager extends RequestManager<GetPhotosRequest, GetPhotosResponse> {

    public GetPhotosManager(ProviderRequestGenerator generator) {
        super(GetPhotosResponse.class, generator);
    }
}
