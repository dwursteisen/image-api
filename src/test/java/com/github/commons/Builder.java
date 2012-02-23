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

    public Builder(String propertyApiKey, String propertySecretKey) {
        this.property = propertyApiKey;
        this.secretProperty = propertySecretKey;
    }

    public Builder<PROVIDER> withApiKey() {
        java.io.InputStream is = this.getClass().getResourceAsStream("/secret.properties");
        Properties properties = new Properties();
        try {
            if(is == null) { throw new IOException("File not found !"); }
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Error during loading secret.properties file :" +
                    " Is the file into your test/resources directory ?");
        }

        apiKey = properties.getProperty(property);
        secret = properties.getProperty(secretProperty);
        return this;
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
