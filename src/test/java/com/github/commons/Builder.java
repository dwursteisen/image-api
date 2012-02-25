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
    private String secret = null;

    private final String property;
    private final String secretProperty;

    private Properties properties = null;

    public Builder(String propertyApiKey, String propertySecretKey) {
        this.property = propertyApiKey;
        this.secretProperty = propertySecretKey;
    }

    public Builder<PROVIDER> withApiKey() {
        readPropertiesFile();
        apiKey = getProperty(property);
        secret = getProperty(secretProperty);
        return this;
    }

    protected String getProperty(String propertyName) {
        if (properties == null) {
            readPropertiesFile();
        }
        return properties.getProperty(propertyName);
    }

    private void readPropertiesFile() {
        java.io.InputStream is = this.getClass().getResourceAsStream("/secret.properties");
        properties = new Properties();
        try {
            if (is == null) {
                throw new IOException("File not found !");
            }
            properties.load(is);
        } catch (IOException e) {
            properties = null;
            throw new RuntimeException("Error during loading secret.properties file :" +
                    " Is the file into your test/resources directory ?");

        }

    }

    public Builder<PROVIDER> withApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public Builder<PROVIDER> withSecretKey(String secretKey) {
        this.secret = secretKey;
        return this;
    }

    public abstract PROVIDER build();

    protected String getApiKey() {
        return apiKey;
    }

    protected String getSecret() {
        return secret;
    }
}
