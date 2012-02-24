package com.github.flickr.api.commons;

import com.google.gson.annotations.SerializedName;


public class FlickrContent {
    @SerializedName("_content")
    private String content;

    public String getContent() {
        return content;
    }
}
