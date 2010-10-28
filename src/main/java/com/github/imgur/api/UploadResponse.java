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

import com.github.imgur.request.Response;

public class UploadResponse implements Response {
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

    private Upload upload = new Upload();

    public Links getLinks() {
        return upload.links;
    }

    public Image getImage() {
        return upload.image;
    }

    static private class Upload {
        private Links links;
        private Image image;
    }

    static public class Image {
        private boolean name;
        private String title;
        private String caption;
        private String hash;
        private String deleteHash;
        private String datetime;
        private String type;
        private String animated;
        private int width;
        private int height;
        private int size;
        private int view;
        private int bandwidth;

        public boolean isName() {
            return name;
        }

        public String getTitle() {
            return title;
        }

        public String getCaption() {
            return caption;
        }

        public String getHash() {
            return hash;
        }

        public String getDeleteHash() {
            return deleteHash;
        }

        public String getDatetime() {
            return datetime;
        }

        public String getType() {
            return type;
        }

        public String getAnimated() {
            return animated;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public int getSize() {
            return size;
        }

        public int getView() {
            return view;
        }

        public int getBandwidth() {
            return bandwidth;
        }
    }

    static public class Links {
        private String original;
        private String imgur_page;
        private String delete_page;
        private String small_square;
        private String large_thumbnail;

        public String getOriginal() {
            return original;
        }

        public String getImgur_page() {
            return imgur_page;
        }

        public String getDelete_page() {
            return delete_page;
        }

        public String getSmall_square() {
            return small_square;
        }

        public String getLarge_thumbnail() {
            return large_thumbnail;
        }
    }
}
