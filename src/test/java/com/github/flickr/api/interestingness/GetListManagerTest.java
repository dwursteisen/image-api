package com.github.flickr.api.interestingness;

import com.github.flickr.Flickr;
import com.github.flickr.FlickrBuilder;
import com.github.flickr.api.commons.Extras;
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
        assertEquals("ok", response.getStat());
        assertEquals(1, response.getPage());
        assertEquals(response.getPerPage(), response.getPhotos().size());
    }

    @Test
    public void can_call_flickr_with_parameters() throws IOException {
        GetListRequest request = new GetListRequest();
        request.setPage(5);
        GetListResponse response = flickr.interestingness().call(request);
        assertEquals("ok", response.getStat());
        assertEquals(5, response.getPage());
    }

    @Test
    public void can_call_flickr_with_extras() throws IOException {
        GetListRequest request = new GetListRequest();
        request.addExtras(Extras.UrlMedium);
        GetListResponse response = flickr.interestingness().call(request);
        assertNotNull(response.getPhotos().get(0).getUrlMedium());

    }

    @Test(expected = IllegalArgumentException.class)
    public void can_call_flickr_with_missing_extras() throws IOException {
        GetListRequest request = new GetListRequest();
        GetListResponse response = flickr.interestingness().call(request);
        assertNotNull(response.getPhotos().get(0).getUrlMedium());
    }

}
