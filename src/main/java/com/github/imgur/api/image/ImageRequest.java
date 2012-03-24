/*
 * Copyright (C) 2010 David Wursteisen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.imgur.api.image;

import com.github.imgur.api.commons.ImgUrRequest;

import java.util.Map;


public class ImageRequest extends ImgUrRequest {
    private String hash;

    public ImageRequest(String hash) {
        this.hash = hash;
    }

    public Map<String, Object> buildParameters() {
        return emptyParameters();
    }

    @Override
    public boolean isOAuth() {
        return false;
    }

    @Override
    public String requestUrl(String baseUrl) {
        return baseUrl + "image/" + hash + ".json";
    }
}
