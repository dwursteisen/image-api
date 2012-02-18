package com.github.flickr.api.test;

import com.github.commons.Response;
import com.google.gson.annotations.SerializedName;

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

    private static class FlickrContent {
        @SerializedName("_content")
        private String content;

        public String getContent() {
            return content;
        }
    }

    private FlickrContent method;
    private FlickrContent name;
    private String stat;

    public String getMethod() {
        return method.getContent();
    }

    public String getName() {
        return name.getContent();
    }

    public String getStat() {
        return stat;
    }
}
