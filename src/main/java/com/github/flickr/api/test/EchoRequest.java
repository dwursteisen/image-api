package com.github.flickr.api.test;

import com.github.commons.Request;

import java.util.HashMap;
import java.util.Map;

public class EchoRequest implements Request {


    private String testParameter = "This is a sample";

    @Override
    public Map<String, Object> buildParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("method", "flickr.test.echo");
        parameters.put("testParameter", testParameter);
        return parameters;
    }

    @Override
    public boolean isOAuth() {
        return false;
    }

    public void setTestParameter(String testParameter) {
        this.testParameter = testParameter;
    }
}
