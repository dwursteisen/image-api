package com.github.imgur;

import com.github.commons.Builder;

/**
 * User: Wursteisen David
 * Date: 22/02/12
 * Time: 21:10
 */
public class ImgUrBuilder extends Builder<ImgUr> {

    public ImgUrBuilder() {
        super("imgur.apikey");
    }

    @Override
    public ImgUr build() {
        return new ImgUr(getApiKey());
    }
}
