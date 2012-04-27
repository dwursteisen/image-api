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


package com.github.imgur.api.stats;

import com.github.imgur.api.commons.ImgUrResponse;
import com.google.gson.annotations.SerializedName;

/*
{
    "stats": {
        "most_popular_images": ["gn2gN", "cXQqZ", "JiPqw", "WdRim", "zPxWo"],
        "images_uploaded": 1627648,
        "images_veiwed": 1080303365,
        "bandwidth_used": "4.58 TB",
        "average_image_size": "40.74 KB"
    }
}
*/

public class StatsResponse extends ImgUrResponse {


    static private class Stats {
        @SerializedName("most_popular_images")
        private String[] mostPopularImages;

        @SerializedName("images_uploaded")
        private int imagesUploaded;

        @SerializedName("images_veiwed")
        private int imagesViewed;

        @SerializedName("bandwidth_used")
        private String bandwidthUsed;

        @SerializedName("average_image_size")
        private String averageImageSize;

        public Stats() {

        }
    }

    @SerializedName("stats")
    private Stats stats = new Stats();

    public String getAverageImageSize() {
        return stats.averageImageSize;
    }

    public String getBandwidthUsed() {
        return stats.bandwidthUsed;
    }

    public String[] getMostPopularImages() {
        return stats.mostPopularImages;
    }

    public int getImagesUploaded() {
        return stats.imagesUploaded;
    }

    public int getImagesViewed() {
        return stats.imagesViewed;
    }

}
