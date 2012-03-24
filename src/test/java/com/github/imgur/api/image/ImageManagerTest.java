package com.github.imgur.api.image;

import com.github.imgur.ImgUr;
import com.github.imgur.ImgUrBuilder;
import com.google.gson.Gson;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * User: Wursteisen David
 * Date: 22/02/12
 * Time: 21:31
 */
public class ImageManagerTest {

    private static ImgUr imgur;

    @BeforeClass
    public static void setUpClass() {
        imgur = new ImgUrBuilder().withApiKey().build();
    }

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


    @Test
    public void can_deserialize_imgur_response() {
        ImageResponse response = new Gson().fromJson(imgUrResponse, ImageResponse.class);
        assertEquals(408360, response.getImage().getViews());
    }

    @Test
    public void can_call_imgur() throws IOException {
        final String hash = "ABktn";
        ImageResponse result = imgur.call(new ImageRequest(hash));

        assertNotNull(result.getImage());
        assertEquals("2010-08-31 12:10:40", result.getImage().getDatetime());
    }

    @Test(expected = IOException.class)
    public void cant_ask_fake_image() throws IOException {
        final String hash = "FAKE";
        imgur.call(new ImageRequest(hash));
    }


}
