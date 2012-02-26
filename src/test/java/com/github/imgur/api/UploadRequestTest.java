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

package com.github.imgur.api;

import com.github.imgur.ImgUr;
import com.github.imgur.ImgUrBuilder;
import com.github.imgur.api.upload.UploadRequest;
import com.github.imgur.api.upload.UploadResponse;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import static org.junit.Assert.*;


public class UploadRequestTest {

    private static ImgUr imgur;

    @BeforeClass
    public static void setUpClass() {
        imgur = new ImgUrBuilder().withAnonymousKey().build();
    }

    @Test
    public void build() throws IOException {
        UploadRequest.Builder builder = new UploadRequest.Builder();
        UploadRequest request = builder.withTitle("title").build();
        assertEquals("title", request.getTitle());
    }

    @Test
    public void buildImageUrl() throws IOException {
        final URL imageUrl = new URL("http://github.com/images/modules/header/logov3-hover.png");

        UploadRequest.Builder builder = new UploadRequest.Builder();
        UploadRequest request = builder.withTitle("title").withImageUrl(imageUrl).build();
        assertEquals("title", request.getTitle());
        assertNotNull(request.getImageUrl());

    }


    @Test
    public void buildImageFromFile() throws IOException {

        final File image = new File("./src/test/resources/uploadme.jpg");
        UploadRequest.Builder builder = new UploadRequest.Builder();

        UploadRequest request = builder.withImageFile(image).build();
        assertNotNull(request.getImageData());
        assertNull(request.getImageUrl());

    }


    @Test
    public void buildImageFromByteArray() throws IOException {

        final File image = new File("./src/test/resources/uploadme.jpg");
        byte[] array = FileUtils.readFileToByteArray(image);

        UploadRequest.Builder builder = new UploadRequest.Builder();

        UploadRequest request = builder.withImageData(array).build();
        assertNotNull(request.getImageData());
        assertNull(request.getImageUrl());

    }


    @Test
    public void buildParameters() throws IOException {
        final URL imageUrl = new URL("http://github.com/images/modules/header/logov3-hover.png");

        UploadRequest.Builder builder = new UploadRequest.Builder();
        UploadRequest request = builder.withTitle("myTitle").withImageUrl(imageUrl).build();

        Map<String, Object> parameters = request.buildParameters();
        assertEquals("myTitle", parameters.get("title").toString());
        assertEquals("http://github.com/images/modules/header/logov3-hover.png", parameters.get("image").toString());
    }

    @Test
    public void buildParametersWithoutTitle() throws IOException {
        final URL imageUrl = new URL("http://github.com/images/modules/header/logov3-hover.png");

        UploadRequest.Builder builder = new UploadRequest.Builder();
        UploadRequest request = builder.withImageUrl(imageUrl).build();

        Map<String, Object> parameters = request.buildParameters();
        assertFalse(parameters.keySet().contains("title"));
        assertEquals("http://github.com/images/modules/header/logov3-hover.png", parameters.get("image").toString());
    }

    @Test
    public void can_upload_url_image() throws IOException {
        URL imageUrl = new URL("http://i.imgur.com/jxGar.jpg");

        UploadRequest.Builder builder = new UploadRequest.Builder();
        UploadRequest request = builder.withImageUrl(imageUrl).build();

        UploadResponse response = imgur.call(request);
        assertNotNull(response.getLinks());
    }


    @Test
    public void can_upload_image_file() throws IOException {
        final File image = new File("./src/test/resources/uploadme.jpg");
        UploadRequest.Builder builder = new UploadRequest.Builder();

        UploadRequest request = builder.withImageFile(image).build();
        UploadResponse response = imgur.call(request);
        assertNotNull(response.getLinks());

        System.err.println("...just upload an image that you will find on the url : ");
        System.err.println("URL : " + response.getLinks().getImgurPage());
        System.err.println("DELETE URL : " + response.getLinks().getDeletePage());

    }

}
