package com.github.flickr.api.test;

import com.github.commons.Response;
import com.github.flickr.api.commons.FlickrContent;

public class EchoResponse implements Response {


    /**
     * jsonFlickrApi(
     * {
     * "method": { "_content":"flickr.test.echo" },
     * "name":{"_content":"value"},
     * "api_key":{"_content":"------------------"},
     * "format":{"_content":"json"},
     * "stat":"ok"
     * }
     * )
     */
    private FlickrContent method;
    private FlickrContent name;
    private FlickrContent testParameter;
    private String stat;

    public String getMethod() {
        return method.getContent();
    }

    public String getName() {
        return name.getContent();
    }

    public String getTestParameter() {
        return testParameter.getContent();
    }

    public String getStat() {
        return stat;
    }
}
