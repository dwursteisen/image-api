package com.github.facebook.api.albums;

import com.github.commons.RequestManager;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: Wursteisen David
 * Date: 27/04/12
 * Time: 15:36
 */
public class AlbumsResponseTest {

    private static final String json = "   {\n" +
            "       \"data\": [\n" +
            "          {\n" +
            "             \"id\": \"54354353\",\n" +
            "             \"from\": {\n" +
            "                \"name\": \"BLaalnln\",\n" +
            "                \"id\": \"662643543\"\n" +
            "             },\n" +
            "             \"name\": \"Cover Photos\",\n" +
            "             \"link\": \"https://www.facebook.com/album.php?fbid=10150442827554554&id=6545492005&aid=333304\",\n" +
            "             \"cover_photo\": \"10150442826543006\",\n" +
            "             \"privacy\": \"everyone\",\n" +
            "             \"count\": 1,\n" +
            "             \"type\": \"normal\",\n" +
            "             \"created_time\": \"2012-01-01T19:36:41+0000\",\n" +
            "             \"updated_time\": \"2012-01-01T19:36:44+0000\",\n" +
            "             \"can_upload\": false\n" +
            "          }\n" +
            "       ],\n" +
            "       \"paging\": {\n" +
            "          \"previous\": \"https://graph.facebook.com/me/albums?access_token=AAAAfghfghfg456456EtkOpRZC8FUJ54jZBix6C22P00wTLYvq3cXaDxvyuaTvNoKURj4yJNmCX9V8RGe8DpBqIUZC5WBcByMYktWZCAZDZD&limit=25&since=1325446601&__paging_token=1054545442827547006&__previous=1\",\n" +
            "          \"next\": \"https://graph.facebook.com/me/albums?access_token=AAAAAAITEghMBAF3XNnxxEtkOpRZC8FUJ54jZBix6C22P00wTLYvq3cXaDxvyuaTvNoKURj4yJNmCX9V8RGe8DpBqIUZC5WBdfghjkAZDZD&limit=25&until=1200359291&__paging_token=765545454005\"\n" +
            "       }\n" +
            "    }";
    private RequestManager manager;

    @Before
    public void setUp() {
        manager = new RequestManager(null);
    }

    @Test
    public void can_deserialize() throws IOException {
        AlbumsResponse response = manager.createObjectResponse(json, AlbumsResponse.class);
        assertThat(response.getData().get(0).getName()).matches("Cover Photos");
    }
}
