package com.github.flickr.api.test;


import com.github.commons.RequestManager;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.fest.assertions.api.Assertions.assertThat;

public class EchoResponseTest {

    private static final String json = "{ \"method\": { \"_content\": \"flickr.test.echo\" }, \"api_key\": { \"_content\": \"-----------------\" }, \"format\": { \"_content\": \"json\" }, \"nojsoncallback\": { \"_content\": 1 }, \"auth_token\": { \"_content\": \"-------------------\" }, \"api_sig\": { \"_content\": \"---------------\" }, \"stat\": \"ok\" }";

    private RequestManager manager;

    @Before
    public void setUp() {
        manager = new RequestManager(null);
    }

    @Test
    public void can_parse_response() throws IOException {
        EchoResponse response = manager.createObjectResponse(json, EchoResponse.class);
        assertThat(response.getStat()).isEqualTo("ok");
    }
}
