package com.github.dwursteisen.imgur.api;

import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 19 oct. 2010
 * Time: 23:39:48
 * To change this template use File | Settings | File Templates.
 */
public class StatsResponseTest {
    private Gson gson;

    final private String expectedResult =
            "{" +
                    "\"stats\": {" +
                    "\"most_popular_images\": [\"gn2gN\", \"cXQqZ\", \"JiPqw\", \"WdRim\", \"zPxWo\"]," +
                    "\"images_uploaded\": 1627648," +
                    "\"images_veiwed\": 1080303365," +
                    "\"bandwidth_used\": \"4.58 TB\"," +
                    "\"average_image_size\": \"40.74 KB\"" +
                    "}" +
                    "}";


    @Before
    public void setUp() throws Exception {
        gson = new Gson();

    }

    @Test
    public void serialization() {
        StatsResponse stats = new StatsResponse();
        stats.setMostPopularImages(new String[]{"gn2gN", "cXQqZ", "JiPqw", "WdRim", "zPxWo"});
        stats.setImagesUploaded(1627648);
        stats.setImagesViewed(1080303365);
        stats.setBandwidthUsed("4.58 TB");
        stats.setAverageImageSize("40.74 KB");
        String result = gson.toJson(stats);

        assertEquals(StringUtils.deleteWhitespace(expectedResult), StringUtils.deleteWhitespace(result));
    }

    @Test
    public void deserialization() {
        StatsResponse stats = gson.fromJson(expectedResult, StatsResponse.class);
        assertEquals("4.58 TB", stats.getBandwidthUsed());

    }
}
