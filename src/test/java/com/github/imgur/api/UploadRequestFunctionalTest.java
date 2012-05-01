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
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.fest.assertions.api.Assertions.assertThat;


public class UploadRequestFunctionalTest {

    private static ImgUr imgur;

    @BeforeClass
    public static void setUpClass() {
        imgur = new ImgUrBuilder().withAnonymousKey().build();
    }

    @Test
    public void can_upload_url_image() throws IOException {
        URL imageUrl = new URL("http://i.imgur.com/jxGar.jpg");

        UploadRequest.Builder builder = new UploadRequest.Builder();
        UploadRequest request = builder.withImageUrl(imageUrl).build();

        UploadResponse response = imgur.call(request);
        assertThat(response.getLinks()).isNotNull();
    }


    @Test
    public void can_upload_image_file() throws IOException {
        final File image = new File("./src/test/resources/uploadme.jpg");
        UploadRequest.Builder builder = new UploadRequest.Builder();

        UploadRequest request = builder.withImageFile(image).build();
        UploadResponse response = imgur.call(request);
        assertThat(response.getLinks()).isNotNull();

        System.err.println("...just upload an image that you will find on the url : ");
        System.err.println("URL : " + response.getLinks().getImgurPage());
        System.err.println("DELETE URL : " + response.getLinks().getDeletePage());

    }

}
