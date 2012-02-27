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

import com.github.imgur.api.commons.ImgurResponse;
import com.google.gson.annotations.SerializedName;


public class ImageResponse extends ImgurResponse {
    /*
    {
    "image": {
        "image": {
            "title": null,
            "caption": null,
            "hash": "yPdcE",
            "datetime": "2010-08-16 20:13:27",
            "type": "image\/gif",
            "animated": "false",
            "width": 314,
            "height": 115,
            "size": 4413,
            "views": 0,
            "bandwidth": 0
        },
        "links": {
            "original": "http:\/\/imgur.com\/yPdcE.gif",
            "imgur_page": "http:\/\/imgur.com\/yPdcE",
            "small_square": "http:\/\/imgur.com\/yPdcEs.jpg",
            "large_thumbnail": "http:\/\/imgur.com\/yPdcEl.jpg"
        }
    }
}
*/
    static private class Image {
        private ImageProperty image;
        private Links links;
    }

    static public class ImageProperty {
        private String title;
        private String caption;
        private String hash;
        private String datetime;
        private String type;
        private boolean animated;
        private int width;
        private int height;
        private long size;
        private long views;
        private long bandwidth;

        public String getTitle() {
            return title;
        }

        public String getCaption() {
            return caption;
        }

        public String getHash() {
            return hash;
        }

        public String getDatetime() {
            return datetime;
        }

        public String getType() {
            return type;
        }

        public boolean isAnimated() {
            return animated;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public long getSize() {
            return size;
        }

        public long getViews() {
            return views;
        }

        public long getBandwidth() {
            return bandwidth;
        }
    }

    static public class Links {
        private String original;
        @SerializedName("imgur_page")
        private String imgurPage;
        @SerializedName("small_square")
        private String smallSquare;
        @SerializedName("lage_thumbnail")
        private String largeThumbnail;

        public String getOriginal() {
            return original;
        }

        public String getImgurPage() {
            return imgurPage;
        }

        public String getSmallSquare() {
            return smallSquare;
        }

        public String getLargeThumbnail() {
            return largeThumbnail;
        }
    }


    private Image image = new Image();

    public Links getLinks() {
        return image.links;
    }

    public ImageProperty getImageProperty() {
        return image.image;
    }

}
