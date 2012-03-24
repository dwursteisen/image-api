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

package com.github.imgur.api.upload;

import com.github.imgur.api.commons.ImgurRequest;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.scribe.model.Token;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class UploadRequest extends ImgurRequest {
    private String title;
    private byte[] imageData;
    private URL imageUrl;

    public Map<String, Object> buildParameters() {
        final Map<String, Object> result = new HashMap<String, Object>();
        if (imageUrl != null) {
            result.put("image", imageUrl);
        } else if (imageData != null) {
            result.put("image", new String(Base64.encodeBase64(imageData)));
        }
        if (title != null) {
            result.put("title", title);
        }


        return result;
    }

    @Override
    public boolean isOAuth() {
        return (getAccessToken() != null);
    }

    @Override
    public String requestUrl(String baseUrl) {
        return baseUrl + "upload.json";
    }

    public static class Builder {
        private byte[] imageData;
        private String title;
        private File imageFile;
        private URL imageUrl;
        private Token accessToken;

        public Builder withImageData(byte[] imageData) {
            this.imageData = imageData.clone();
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
            if (accessToken != null) {
                request.setAccessToken(accessToken);
            }
            return request;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withAccessToken(Token accessToken) {
            this.accessToken = accessToken;
            return this;
        }
    }

}
