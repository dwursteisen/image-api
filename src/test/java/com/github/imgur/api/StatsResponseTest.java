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

import com.github.commons.RequestManager;
import com.github.imgur.ImgUr;
import com.github.imgur.ImgUrBuilder;
import com.github.imgur.api.stats.StatsRequest;
import com.github.imgur.api.stats.StatsResponse;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.fest.assertions.Assertions.assertThat;


public class StatsResponseTest {


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


    private static ImgUr imgur;
    private RequestManager manager;

    @BeforeClass
    public static void setUpClass() {
        imgur = new ImgUrBuilder().withApiKey().build();
    }

    @Before
    public void setUp() throws Exception {
        manager = new RequestManager(null);

    }

    @Test
    public void can_perform_deserialization() throws IOException {
        StatsResponse response = manager.createObjectResponse(expectedResult, StatsResponse.class);
        assertThat(response.getBandwidthUsed()).isEqualTo("4.58 TB");
    }


    @Ignore("stats request no more working on imgur...")
    @Test
    public void can_call_imgur() throws IOException {
        StatsResponse response = imgur.call(new StatsRequest());
        assertThat(response.getBandwidthUsed()).isNotNull();
    }
}
