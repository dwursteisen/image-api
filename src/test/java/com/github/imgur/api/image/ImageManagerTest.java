package com.github.imgur.api.image;

import com.github.commons.RequestManager;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: Wursteisen David
 * Date: 22/02/12
 * Time: 21:31
 */
public class ImageManagerTest {

    private static final String imgUrResponse =
            "{\"image\":" +
                    "{\"image\":" +
                    "{\"title\":null," +
                    "\"caption\":null," +
                    "\"hash\":\"ABktn\"," +
                    "\"datetime\":\"2010-08-31 12:10:40\"," +
                    "\"type\":\"image\\/gif\"," +
                    "\"animated\":\"false\"," +
                    "\"width\":710," +
                    "\"height\":487," +
                    "\"size\":65049," +
                    "\"views\":408360," +
                    "\"bandwidth\":26563409640}," +
                    "\"links\":" +
                    "{\"original\":\"http:\\/\\/i.imgur.com\\/ABktn.gif\"," +
                    "\"imgur_page\":\"http:\\/\\/imgur.com\\/ABktn\"," +
                    "\"small_square\":\"http:\\/\\/i.imgur.com\\/ABktns.jpg\"," +
                    "\"large_thumbnail\":\"http:\\/\\/i.imgur.com\\/ABktnl.jpg\"}" +
                    "}" +
                    "}\n";

    private RequestManager manager;

    @Before
    public void setUp() {
        manager = new RequestManager(null);
    }

    @Test
    public void can_deserialize_imgur_response() throws IOException {
        ImageResponse response = manager.createObjectResponse(imgUrResponse, ImageResponse.class);
        assertThat(response.getImage().getViews()).isEqualTo(408360);
    }


}
