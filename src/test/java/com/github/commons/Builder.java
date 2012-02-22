package com.github.commons;

import java.io.IOException;
import java.util.Properties;

/**
 * User: Wursteisen David
 * Date: 22/02/12
 * Time: 21:04
 */
public abstract class Builder<PROVIDER> {
    private String apiKey = null;

    private final String property;

    public Builder(String propertyApiKey) {
        this.property = propertyApiKey;
    }

    public Builder<PROVIDER> withApiKey() {
        java.io.InputStream is = this.getClass().getResourceAsStream("/secret.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Error during loading secret.properties file :" +
                    " Is the file into your test/resources directory ?");
        }

        apiKey = properties.getProperty(property);
        return this;
    }

    public Builder<PROVIDER> withApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public abstract PROVIDER build();

    protected String getApiKey() {
        return apiKey;
    }
}
