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

package com.github.dwursteisen.imgur.api;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import static org.junit.Assert.*;


public class UploadRequestTest {

    @Test
    public void build() {
        UploadRequest.Builder builder = new UploadRequest.Builder();
        UploadRequest request = builder.withTitle("title").build();
        assertEquals("title", request.getTitle());
    }

    @Test
    public void buildImageUrl() throws MalformedURLException {
        final URL imageUrl = new URL("http://github.com/images/modules/header/logov3-hover.png");

        UploadRequest.Builder builder = new UploadRequest.Builder();
        UploadRequest request = builder.withTitle("title").withImageUrl(imageUrl).build();
        assertEquals("title", request.getTitle());
        assertNotNull(request.getImageUrl());

    }

    @Test
    public void buildParameters() throws MalformedURLException {
        final URL imageUrl = new URL("http://github.com/images/modules/header/logov3-hover.png");

        UploadRequest.Builder builder = new UploadRequest.Builder();
        UploadRequest request = builder.withTitle("myTitle").withImageUrl(imageUrl).build();

        Map<String, Object> parameters = request.buildParameters();
        assertEquals("myTitle", parameters.get("title").toString());
        assertEquals("http://github.com/images/modules/header/logov3-hover.png", parameters.get("image").toString());
    }

    @Test
    public void buildParametersWithoutTitle() throws MalformedURLException {
        final URL imageUrl = new URL("http://github.com/images/modules/header/logov3-hover.png");

        UploadRequest.Builder builder = new UploadRequest.Builder();
        UploadRequest request = builder.withImageUrl(imageUrl).build();

        Map<String, Object> parameters = request.buildParameters();
        assertFalse(parameters.keySet().contains("title"));
        assertEquals("http://github.com/images/modules/header/logov3-hover.png", parameters.get("image").toString());
    }
}
