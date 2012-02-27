package com.github.flickr.api.test;

import com.github.flickr.api.commons.FlickrContent;
import com.github.flickr.api.commons.FlickrResponse;

public class LoginResponse extends FlickrResponse {

    /*
            jsonFlickrApi({
                "user":{
                    "id":"userid",
                    "username":{
                        "_content":"username"
                      }
                 },
                 "stat":"ok"
            })
     */

    private static class User {
        private String id;
        private FlickrContent username;

    }

    private String stat;
    private User user;

    public String getStat() {
        return stat;
    }

    public String getUserId() {
        return user.id;
    }

    public String getUsername() {
        return user.username.getContent();
    }


    @Override
    public String toString() {
        return "LoginResponse{" +
                "stat='" + stat + '\'' +
                ", user=" + getUserId() + ' ' + getUsername() +
                '}';
    }
}
