package com.github.flickr.api.test;

import com.github.flickr.Flickr;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EchoManagerTest {

    private Flickr flickr;
    private EchoManager echoManager;


    @Before
    public void setUp() throws IOException {
        java.io.InputStream is = this.getClass().getResourceAsStream("/secret.properties");
        Properties properties = new Properties();
        properties.load(is);

        flickr = new Flickr(properties.getProperty("flickr.apikey"));
        echoManager = flickr.echo();
    }

    @Test
    public void can_call_flickr() throws IOException {
        EchoResponse response = echoManager.call(new EchoRequest());
        assertNotNull(response);
        assertEquals("ok", response.getStat());
    }

    @Test
    public void can_call_flickr_with_custom_parameter() throws IOException {
        EchoRequest request = new EchoRequest();
        request.setTestParameter("MyFakeParameter");
        EchoResponse response = echoManager.call(request);
        assertEquals("MyFakeParameter", response.getTestParameter());
    }
}