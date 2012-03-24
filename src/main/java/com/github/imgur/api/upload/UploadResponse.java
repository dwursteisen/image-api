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

import com.github.imgur.api.commons.ImgurResponse;
import com.github.imgur.api.model.Image;
import com.github.imgur.api.model.ImageProperty;
import com.github.imgur.api.model.Links;

public class UploadResponse extends ImgurResponse {
    /*
    {
    "upload": {
        "image": {
            "name": false,
            "title": "",
            "caption": "",
            "hash": "cSNjk",
            "deletehash": "ZnKGru1reZKoabU",
            "datetime": "2010-08-16 22:43:22",
            "type": "image\/jpeg",
            "animated": "false",
            "width": 720,
            "height": 540,
            "size": 46174,
            "views": 0,
            "bandwidth": 0
        },
        "links": {
            "original": "http:\/\/imgur.com\/cSNjk.jpg",
            "imgur_page": "http:\/\/imgur.com\/cSNjk",
            "delete_page": "http:\/\/imgur.com\/delete\/ZnKGru1reZKoabU",
            "small_square": "http:\/\/imgur.com\/cSNjks.jpg",
            "large_thumbnail": "http:\/\/imgur.com\/cSNjkl.jpg"
        }
    }
}
     */

    private ImageProperty upload = new ImageProperty();

    public Links getLinks() {
        return upload.getLinks();
    }

    public Image getImage() {
        return upload.getImage();
    }

    @Override
    public String toString() {
        return "{upload : delete links " + getLinks().getDeletePage() + " }";
    }
}
