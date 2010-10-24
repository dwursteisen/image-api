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

import com.github.dwursteisen.imgur.api.StatsRequest;
import com.github.dwursteisen.imgur.api.StatsResponse;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertNotNull;


public class RequestManagerTest {
    private RequestManager<StatsRequest, StatsResponse> manager;


    @Before
    public void setUp() {
        manager = new RequestManager<StatsRequest, StatsResponse>(StatsResponse.class);
    }

    @Test
    public void call() throws IOException {

        StatsResponse result = manager.call(new StatsRequest());
        assertNotNull(result.getBandwidthUsed());

    }
}
