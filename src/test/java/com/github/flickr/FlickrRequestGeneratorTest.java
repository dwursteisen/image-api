package com.github.flickr;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: Wursteisen David
 * Date: 18/02/12
 * Time: 12:40
 */
public class FlickrRequestGeneratorTest {


    private FlickrRequestGenerator generator;

    @Before
    public void setUp() {
        generator = new FlickrRequestGenerator("api");
    }

    @Test
    public void can_validate_response() {
        String json = generator.validateResponse("jsonFlickrApi({})");
        assertEquals("{}", json);
    }
}
