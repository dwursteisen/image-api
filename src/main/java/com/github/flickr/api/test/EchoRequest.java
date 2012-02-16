package com.github.flickr.api.test;

import com.github.commons.Request;

import java.util.HashMap;
import java.util.Map;

public class EchoRequest implements Request {

    @Override
    public String createServiceUrl(String baseUrl) {
        return baseUrl;
    }

    @Override
    public Map<String, Object> buildParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("method", "flickr.test.echo");
        parameters.put("format", "json");
        return parameters;
    }
}
