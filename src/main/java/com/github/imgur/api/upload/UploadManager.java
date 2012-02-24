package com.github.imgur.api.upload;

import com.github.commons.ProviderRequestGenerator;
import com.github.commons.RequestManager;

/**
 * User: Wursteisen David
 * Date: 22/02/12
 * Time: 21:18
 */
public class UploadManager extends RequestManager<UploadRequest, UploadResponse> {

    public UploadManager(ProviderRequestGenerator provider) {
        super(UploadResponse.class, provider);
    }
}
