package com.github.imgur.api.album;

import com.github.commons.RequestManager;
import com.github.imgur.ImgUr;
import com.github.imgur.ImgUrBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: Wursteisen David
 * Date: 24/03/12
 * Time: 14:20
 */
public class AlbumResponseTest {
    private static ImgUr imgur;

    private static final String response = "{\n" +
            "        \"album\": {\n" +
            "        \"title\": \"Album Title\",\n" +
            "                \"description\": \"Album Description\",\n" +
            "                \"cover\": \"ix7Yt\",\n" +
            "                \"layout\": \"grid\",\n" +
            "                \"images\": [\n" +
            "        {\n" +
            "            \"image\": {\n" +
            "            \"title\": null,\n" +
            "                    \"caption\": null,\n" +
            "                    \"hash\": \"ix7Yt\",\n" +
            "                    \"datetime\": \"2012-03-22 21:47:52\",\n" +
            "                    \"type\": \"image/png\",\n" +
            "                    \"animated\": \"false\",\n" +
            "                    \"width\": 1000,\n" +
            "                    \"height\": 520,\n" +
            "                    \"size\": 15827,\n" +
            "                    \"views\": 0,\n" +
            "                    \"bandwidth\": 0\n" +
            "        },\n" +
            "            \"links\": {\n" +
            "            \"original\": \"http://imgur.com/ix7Yt.png\",\n" +
            "                    \"imgur_page\": \"http://imgur.com/ix7Yt\",\n" +
            "                    \"small_square\": \"http://imgur.com/ix7Yts.jpg\",\n" +
            "                    \"large_thumbnail\": \"http://imgur.com/ix7Ytl.jpg\"\n" +
            "        }\n" +
            "        }\n" +
            "        ]\n" +
            "    }\n" +
            "    }";

    private RequestManager manager;

    @BeforeClass
    public static void setUpClass() {
        imgur = new ImgUrBuilder().withApiKey().build();
    }

    @Before
    public void setUp() {
        manager = new RequestManager(null);
    }

    @Test
    public void can_deserialize_response() throws IOException {
        AlbumResponse albumResponse = manager.createObjectResponse(response, AlbumResponse.class);
        assertThat(albumResponse.getImages().size()).isEqualTo(1);
    }

    @Test
    public void can_call_imgur() throws IOException {
        AlbumResponse albumResponse = imgur.call(new AlbumRequest("27nLQ"));
        assertThat(albumResponse.getImages().size()).isGreaterThan(5); // today, there is more than 5 pics into this album
    }
}
