package com.github.flickr.api.test;

import com.github.flickr.Flickr;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EchoManagerTest {

    private Flickr flickr;

    @Before
    public void setUp() {
        flickr = new Flickr("YOUR API KEY");
    }

    @Test
    public void testCall() throws IOException {
        EchoResponse response = flickr.echo().call(new EchoRequest());
        assertNotNull(response);
        assertEquals("ok", response.getStat());
    }
}
