package com.github.flickr.api.photos.licenses;

import com.google.gson.Gson;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * User: Wursteisen David
 * Date: 30/03/12
 * Time: 00:14
 */
public class GetInfoResponseTest {

    private Gson gson = new Gson();

    private String json = "{ \"licenses\": {\n" +
            "    \"license\": [\n" +
            "      { \"id\": 0, \"name\": \"All Rights Reserved\", \"url\": \"\" },\n" +
            "      { \"id\": 4, \"name\": \"Attribution License\", \"url\": \"http:\\/\\/creativecommons.org\\/licenses\\/by\\/2.0\\/\" },\n" +
            "      { \"id\": 6, \"name\": \"Attribution-NoDerivs License\", \"url\": \"http:\\/\\/creativecommons.org\\/licenses\\/by-nd\\/2.0\\/\" },\n" +
            "      { \"id\": 3, \"name\": \"Attribution-NonCommercial-NoDerivs License\", \"url\": \"http:\\/\\/creativecommons.org\\/licenses\\/by-nc-nd\\/2.0\\/\" },\n" +
            "      { \"id\": 2, \"name\": \"Attribution-NonCommercial License\", \"url\": \"http:\\/\\/creativecommons.org\\/licenses\\/by-nc\\/2.0\\/\" },\n" +
            "      { \"id\": 1, \"name\": \"Attribution-NonCommercial-ShareAlike License\", \"url\": \"http:\\/\\/creativecommons.org\\/licenses\\/by-nc-sa\\/2.0\\/\" },\n" +
            "      { \"id\": 5, \"name\": \"Attribution-ShareAlike License\", \"url\": \"http:\\/\\/creativecommons.org\\/licenses\\/by-sa\\/2.0\\/\" },\n" +
            "      { \"id\": 7, \"name\": \"No known copyright restrictions\", \"url\": \"http:\\/\\/www.flickr.com\\/commons\\/usage\\/\" },\n" +
            "      { \"id\": 8, \"name\": \"United States Government Work\", \"url\": \"http:\\/\\/www.usa.gov\\/copyright.shtml\" }\n" +
            "    ] }, \"stat\": \"ok\" }";

    @Test
    public void can_deserialize() {
        GetInfoResponse response = gson.fromJson(json, GetInfoResponse.class);
        assertThat(response.getLicenses()).hasSize(9);
    }


}
