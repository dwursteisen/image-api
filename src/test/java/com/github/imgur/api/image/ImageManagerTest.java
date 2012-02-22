package com.github.imgur.api.image;

import com.github.imgur.ImgUrBuilder;
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

    private static ImageManager imageManager;

    @BeforeClass
    public static void setUpClass() {
        imageManager = new ImgUrBuilder().withApiKey().build().image();
    }

    @Test
    public void can_call_imgur() throws IOException {
        final String hash = "ABktn";
        ImageResponse result = imageManager.call(new ImageRequest(hash));

        assertNotNull(result.getImageProperty());
        assertEquals("2010-08-31 12:10:40", result.getImageProperty().getDatetime());
    }

    @Test(expected = IOException.class)
    public void cant_ask_fake_image() throws IOException {
        final String hash = "FAKE";
        imageManager.call(new ImageRequest(hash));
    }


}
