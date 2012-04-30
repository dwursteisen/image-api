package com.github.facebook;

import com.github.facebook.api.albums.AlbumsRequest;
import com.github.facebook.api.albums.AlbumsResponse;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: Wursteisen David
 * Date: 22/04/12
 * Time: 17:59
 */
public class FacebookTest {

    @Ignore("I haven't found yet a way to oauth using swing application")
    @Test
    public void can_call_facebook() throws IOException {
        Facebook facebook = new FacebookBuilder().withApiKey().build();
        AlbumsResponse response = facebook.call(new AlbumsRequest());
        assertThat(response).isNotNull();
    }
}
