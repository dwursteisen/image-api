package com.github.flickr.api.people;

import com.github.flickr.Flickr;
import com.github.flickr.FlickrBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * User: Wursteisen David
 * Date: 26/02/12
 * Time: 16:11
 */
public class GetPhotosManagerTest {

    private static Flickr flickr;

    @BeforeClass
    public static void setUpClass() throws Exception {
        flickr = new FlickrBuilder().withApiKey().build();
    }

    @Test
    public void can_call_flickr() throws IOException {
        GetPhotosRequest request = new GetPhotosRequest(FlickrBuilder.getAccessToken());
        GetPhotosResponse response = flickr.call(request);
        assertEquals("ok", response.getStat());

    }
}
