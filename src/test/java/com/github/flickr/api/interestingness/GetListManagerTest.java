package com.github.flickr.api.interestingness;

import com.github.flickr.Flickr;
import com.github.flickr.FlickrBuilder;
import com.github.flickr.api.commons.Extras;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.fest.assertions.Assertions.assertThat;
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
        GetListResponse response = flickr.call(new GetListRequest());
        assertThat(response.getStat()).matches("ok");
        assertThat(response.getPage()).isEqualTo(1);
        assertThat(response.getPerPage()).isEqualTo(response.getPhotos().size());
    }

    @Test
    public void can_call_flickr_with_parameters() throws IOException {
        GetListRequest request = new GetListRequest();
        request.setPage(5);
        GetListResponse response = flickr.call(request);
        assertThat(response.getStat()).matches("ok");
        assertThat(response.getPage()).isEqualTo(5);

    }

    @Test
    public void can_call_flickr_with_extras() throws IOException {
        GetListRequest request = new GetListRequest();
        request.addExtras(Extras.UrlMedium);
        GetListResponse response = flickr.call(request);
        assertNotNull(response.getPhotos().get(0).getUrlMedium());

    }

    @Test(expected = IllegalArgumentException.class)
    public void can_call_flickr_with_missing_extras() throws IOException {
        GetListRequest request = new GetListRequest();
        GetListResponse response = flickr.call(request);
        assertNotNull(response.getPhotos().get(0).getUrlMedium());
    }

}
