package com.github.flickr;

import java.io.IOException;
import java.util.Properties;

/**
 * User: Wursteisen David
 * Date: 18/02/12
 * Time: 14:34
 */
public class FlickrBuilder {

    private String apiKey = null;

    public FlickrBuilder withApiKey() {
        java.io.InputStream is = this.getClass().getResourceAsStream("/secret.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Error during loading secret.properties file :" +
                    " Is the file into your test/resources directory ?");
        }

        apiKey = properties.getProperty("flickr.apikey");
        return this;
    }

    public FlickrBuilder withApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public Flickr build() {
        return new Flickr(apiKey);
    }


}
