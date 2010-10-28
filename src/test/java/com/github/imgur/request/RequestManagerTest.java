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

package com.github.imgur.request;

import com.github.imgur.api.*;
import org.apache.http.NameValuePair;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class RequestManagerTest {
    private RequestManager<StatsRequest, StatsResponse> statsManager;
    private RequestManager<ImageRequest, ImageResponse> imageManager;
    private RequestManager<UploadRequest, UploadResponse> uploadManager;


    @Before
    public void setUp() {
        statsManager = new RequestManager<StatsRequest, StatsResponse>(StatsResponse.class);
        imageManager = new RequestManager<ImageRequest, ImageResponse>(ImageResponse.class);
        uploadManager = new RequestManager<UploadRequest, UploadResponse>(UploadResponse.class);
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

    @Test
    public void callUpload() throws IOException {
        URL imageUrl = new URL("http://i.imgur.com/jxGar.jpg");

        UploadRequest.Builder builder = new UploadRequest.Builder();
        UploadRequest request = builder.withImageUrl(imageUrl).build();

        UploadResponse response = uploadManager.call(request);
        assertNotNull(response.getLinks());
    }


    @Test
    public void callUploadwithImage() throws IOException {
        final File image = new File("./src/test/resources/uploadme.jpg");
        UploadRequest.Builder builder = new UploadRequest.Builder();

        UploadRequest request = builder.withImageFile(image).build();
        UploadResponse response = uploadManager.call(request);
        assertNotNull(response.getLinks());

        System.err.println("...just upload an image that you will find on the url : ");
        System.err.println("URL : " + response.getLinks().getImgurPage());
        System.err.println("DELETE URL : " + response.getLinks().getDeletePage());


    }

    @Test
    public void buildParameters() throws MalformedURLException {
        URL imageUrl = new URL("http://i.imgur.com/jxGar.jpg");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("image", imageUrl);

        UploadRequest request = Mockito.mock(UploadRequest.class);
        Mockito.doReturn(params).when(request).buildParameters();

        List<NameValuePair> result = uploadManager.buildParameters(request);

        assertEquals(2, result.size());
    }

    @Test(expected = IOException.class)
    public void callFakeImage() throws IOException {
        final String hash = "FAKE";
        imageManager.call(new ImageRequest(hash));

    }
}
