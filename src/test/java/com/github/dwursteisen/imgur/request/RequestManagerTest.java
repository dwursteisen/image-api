/*
 * Copyright 2010 David Wursteisen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package com.github.dwursteisen.imgur.request;

import com.github.dwursteisen.imgur.api.ImageRequest;
import com.github.dwursteisen.imgur.api.ImageResponse;
import com.github.dwursteisen.imgur.api.StatsRequest;
import com.github.dwursteisen.imgur.api.StatsResponse;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class RequestManagerTest {
    private RequestManager<StatsRequest, StatsResponse> statsManager;
    private RequestManager<ImageRequest, ImageResponse> imageManager;


    @Before
    public void setUp() {
        statsManager = new RequestManager<StatsRequest, StatsResponse>(StatsResponse.class);
        imageManager = new RequestManager<ImageRequest, ImageResponse>(ImageResponse.class);
    }

    @Test
    public void callStats() throws IOException {

        StatsResponse result = statsManager.call(new StatsRequest());
        assertNotNull(result.getBandwidthUsed());

    }

    @Test
    public void callImage() throws IOException {
        final String hash = "ABktn";
        ImageResponse result = imageManager.call(new ImageRequest(hash));

        assertNotNull(result.getImageProperty());
        assertEquals("2010-08-31 12:10:40", result.getImageProperty().getDatetime());
    }


    @Test(expected = IOException.class)
    public void callFakeImage() throws IOException {
        final String hash = "FAKE";
        ImageResponse result = imageManager.call(new ImageRequest(hash));

    }
}
