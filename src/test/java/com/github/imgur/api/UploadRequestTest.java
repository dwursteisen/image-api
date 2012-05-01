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

import com.github.imgur.api.upload.UploadRequest;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import static org.fest.assertions.api.Assertions.assertThat;


public class UploadRequestTest {

    @Test
    public void can_build_with_title() throws IOException {
        UploadRequest.Builder builder = new UploadRequest.Builder();
        UploadRequest request = builder.withTitle("title").build();
        assertThat(request.buildParameters().get("title")).isEqualTo("title");
    }

    @Test
    public void can_build_with_url_and_title() throws IOException {
        final URL imageUrl = new URL("http://github.com/images/modules/header/logov3-hover.png");

        UploadRequest.Builder builder = new UploadRequest.Builder();
        UploadRequest request = builder.withTitle("title").withImageUrl(imageUrl).build();
        Map<String, Object> params = request.buildParameters();
        assertThat(params.get("image").toString()).isEqualTo("http://github.com/images/modules/header/logov3-hover.png");
        assertThat(params.get("title")).isEqualTo("title");

    }


    @Test
    public void can_build_with_image_file() throws IOException {

        final File image = new File("./src/test/resources/uploadme.jpg");
        UploadRequest.Builder builder = new UploadRequest.Builder();

        UploadRequest request = builder.withImageFile(image).build();
        String imageData = (String) request.buildParameters().get("image");
        assertThat(imageData).doesNotContain("http://");
    }


    @Test
    public void can_build_with_byte_array() throws IOException {

        final File image = new File("./src/test/resources/uploadme.jpg");
        byte[] array = FileUtils.readFileToByteArray(image);

        UploadRequest.Builder builder = new UploadRequest.Builder();

        UploadRequest request = builder.withImageData(array).build();
        String imageData = (String) request.buildParameters().get("image");
        assertThat(imageData).doesNotContain("http://");
    }

    @Test
    public void can_build_with_only_url() throws IOException {
        final URL imageUrl = new URL("http://github.com/images/modules/header/logov3-hover.png");

        UploadRequest.Builder builder = new UploadRequest.Builder();
        UploadRequest request = builder.withImageUrl(imageUrl).build();

        Map<String, Object> parameters = request.buildParameters();
        assertThat("title").isNotIn(parameters.keySet());
        assertThat("http://github.com/images/modules/header/logov3-hover.png").isEqualTo(parameters.get("image").toString());
    }


}
