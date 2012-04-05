package com.github.commons;

import com.github.imgur.api.album.AlbumResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

/**
 * User: Wursteisen David
 * Date: 24/03/12
 * Time: 14:42
 */
@RunWith(MockitoJUnitRunner.class)
public class RequestManagerTest {

    @Mock
    ProviderRequestGenerator generator;

    @Test(expected = IOException.class)
    public void can_return_null_with_wrong_response() throws IOException {
        new RequestManager(generator).createObjectResponse("", AlbumResponse.class);
    }
}
