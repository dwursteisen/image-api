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

import com.github.dwursteisen.imgur.request.Request;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class UploadRequest implements Request {
    private String title;
    private byte[] imageData;
    private URL imageUrl;

    public String createServiceUrl(String baseUrl) {
        return baseUrl + "upload";
    }

    public Map<String, Object> buildParameters() {
        final Map<String, Object> result = new HashMap<String, Object>();
        if (imageUrl != null) {
            result.put("image", imageUrl);
        } else {
            result.put("image", new String(Base64.encodeBase64(imageData)));
        }
        if (title != null) {
            result.put("title", title);
        }


        return result;
    }

    public String getTitle() {
        return title;
    }

    public URL getImageUrl() {
        return imageUrl;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public static class Builder {
        private byte[] imageData;
        private String title;
        private File imageFile;
        private URL imageUrl;

        public Builder withImageData(byte[] imageData) {
            this.imageData = imageData;
            this.imageUrl = null;
            this.imageFile = null;
            return this;
        }

        public Builder withImageUrl(URL imageUrl) {
            this.imageData = null;
            this.imageUrl = imageUrl;
            this.imageFile = null;
            return this;
        }

        public Builder withImageFile(File imageFile) {
            this.imageData = null;
            this.imageUrl = null;
            this.imageFile = imageFile;
            return this;
        }

        public UploadRequest build() throws IOException {
            UploadRequest request = new UploadRequest();
            request.title = this.title;
            request.imageUrl = this.imageUrl;
            request.imageData = this.imageData;
            if (this.imageFile != null) {
                request.imageData = FileUtils.readFileToByteArray(imageFile);
            }
            return request;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }
    }

}
