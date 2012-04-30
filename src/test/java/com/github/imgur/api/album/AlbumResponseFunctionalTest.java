package com.github.imgur.api.album;

import com.github.imgur.ImgUr;
import com.github.imgur.ImgUrBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: Wursteisen David
 * Date: 24/03/12
 * Time: 14:20
 */
public class AlbumResponseFunctionalTest {
    private static ImgUr imgur;

    @BeforeClass
    public static void setUpClass() {
        imgur = new ImgUrBuilder().withApiKey().build();
    }

    @Test
    public void can_call_imgur() throws IOException {
        AlbumResponse albumResponse = imgur.call(new AlbumRequest("27nLQ"));
        assertThat(albumResponse.getImages().size()).isGreaterThan(5); // today, there is more than 5 pics into this album
    }
}
