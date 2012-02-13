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

import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StatsResponseTest {
    private Gson gson;

    final private String expectedResult =
            "{" +
                    "\"stats\": {" +
                    "\"most_popular_images\": [\"gn2gN\", \"cXQqZ\", \"JiPqw\", \"WdRim\", \"zPxWo\"]," +
                    "\"images_uploaded\": 1627648," +
                    "\"images_veiwed\": 1080303365," +
                    "\"bandwidth_used\": \"4.58 TB\"," +
                    "\"average_image_size\": \"40.74 KB\"" +
                    "}" +
                    "}";


    @Before
    public void setUp() throws Exception {
        gson = new Gson();

    }

    @Test
    public void serialization() {
        StatsResponse stats = new StatsResponse();
        stats.setMostPopularImages(new String[]{"gn2gN", "cXQqZ", "JiPqw", "WdRim", "zPxWo"});
        stats.setImagesUploaded(1627648);
        stats.setImagesViewed(1080303365);
        stats.setBandwidthUsed("4.58 TB");
        stats.setAverageImageSize("40.74 KB");
        String result = gson.toJson(stats);

        assertEquals(StringUtils.deleteWhitespace(expectedResult), StringUtils.deleteWhitespace(result));
    }

    @Test
    public void deserialization() {
        StatsResponse stats = gson.fromJson(expectedResult, StatsResponse.class);
        assertEquals("4.58 TB", stats.getBandwidthUsed());

    }
}
