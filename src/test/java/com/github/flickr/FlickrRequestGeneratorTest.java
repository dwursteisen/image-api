package com.github.flickr;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * User: Wursteisen David
 * Date: 18/02/12
 * Time: 12:40
 */
public class FlickrRequestGeneratorTest {


    private FlickrRequestProvider generator;

    @Before
    public void setUp() {
        generator = new FlickrRequestProvider("api");
    }

    @Test
    public void can_validate_response() {
        String json = generator.jsonUpdater("jsonFlickrApi({})");
        assertThat(json).isEqualTo("{}");
    }
}
