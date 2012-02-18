package com.github.flickr.api.interestingness;

import com.github.flickr.Flickr;
import com.github.flickr.FlickrBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * User: Wursteisen David
 * Date: 18/02/12
 * Time: 14:32
 */
public class GetListManagerTest {

    private Flickr flickr;

    @Before
    public void setUp() {
        flickr = new FlickrBuilder().withApiKey().build();
    }

    @Test
    public void can_call_flickr() throws IOException {
        GetListRequest request = new GetListRequest();
        GetListResponse response = flickr.interestingness().call(request);
        assertNotNull(response);
        assertEquals("ok", response.getStat());
        assertEquals(1, response.getPage());
        assertEquals(response.getPerPage(), response.getPhotos().size());
    }

    @Test
    public void can_call_flickr_with_parameters() throws IOException {
        GetListRequest request = new GetListRequest();
        request.setPage(5);
        GetListResponse response = flickr.interestingness().call(request);
        assertNotNull(response);
        assertEquals("ok", response.getStat());
        assertEquals(5, response.getPage());
    }

}
