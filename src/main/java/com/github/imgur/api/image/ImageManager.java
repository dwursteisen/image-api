package com.github.imgur.api.image;

import com.github.commons.ProviderRequestGenerator;
import com.github.commons.RequestManager;

/**
 * User: Wursteisen David
 * Date: 22/02/12
 * Time: 21:16
 */
public class ImageManager extends RequestManager<ImageRequest, ImageResponse> {

    public ImageManager(Class<ImageResponse> clazz, ProviderRequestGenerator provider) {
        super(clazz, provider);
    }
}
