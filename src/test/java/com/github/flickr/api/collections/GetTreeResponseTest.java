package com.github.flickr.api.collections;

import com.github.commons.RequestManager;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * User: Wursteisen David
 * Date: 05/04/12
 * Time: 22:17
 */
public class GetTreeResponseTest {

    private RequestManager manager;
    private final String response = " { \"collections\": {\n" +
            "        \"collection\": [\n" +
            "          { \"id\": \"26030969-72157623698256245\", \"title\": \"Ville 2008 2009\", \"description\": \"\", \"iconlarge\": \"http:\\/\\/farm3.staticflickr.com\\/2703\\/cols\\/72157623698256245_ddc27f2cda_l.jpg\", \"iconsmall\": \"http:\\/\\/farm3.staticflickr.com\\/2703\\/cols\\/72157623698256245_ddc27f2cda_s.jpg\",\n" +
            "            \"set\": [\n" +
            "              { \"id\": \"72157621102443443\", \"title\": \"Dense cité\", \"description\": \"\" },\n" +
            "              { \"id\": \"72157605987528173\", \"title\": \"Détails urbains\", \"description\": \"\" },\n" +
            "              { \"id\": \"72157618566239398\", \"title\": \"Ciels Urbains\", \"description\": \"\" }\n" +
            "            ] },\n" +
            "          { \"id\": \"26030969-72157623698249979\", \"title\": \"Ville 2010\", \"description\": \"\", \"iconlarge\": \"http:\\/\\/farm3.staticflickr.com\\/2732\\/cols\\/72157623698249979_d0ac039d47_l.jpg\", \"iconsmall\": \"http:\\/\\/farm3.staticflickr.com\\/2732\\/cols\\/72157623698249979_d0ac039d47_s.jpg\",\n" +
            "            \"set\": [\n" +
            "              { \"id\": \"72157623822701500\", \"title\": \"Dense Cité 2010\", \"description\": \"\" },\n" +
            "              { \"id\": \"72157623822670686\", \"title\": \"Ciels Urbains 2010\", \"description\": \"\" },\n" +
            "              { \"id\": \"72157623822693292\", \"title\": \"Détails Urbains 2010\", \"description\": \"\" }\n" +
            "            ] }\n" +
            "        ] }, \"stat\": \"ok\" }";


    @Before
    public void setUp() {
        manager = new RequestManager(null);
    }

    @Test
    public void can_deserialize() throws IOException {
        GetTreeResponse response = manager.createObjectResponse(this.response, GetTreeResponse.class);
        assertThat(response.getStat()).matches("ok");
    }
}
