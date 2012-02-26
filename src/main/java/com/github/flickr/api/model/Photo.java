package com.github.flickr.api.model;

import com.github.flickr.api.commons.Extras;
import org.scribe.utils.Preconditions;

/**
* User: Wursteisen David
* Date: 26/02/12
* Time: 16:25
*/
public class Photo {
    private String id;
    private String owner;
    private String secret;
    private String server;
    private int farm;
    private String title;
    private int ispublic;
    private int isfamily;
    private String url_m;
    private int height_m;
    private int width_m;

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getSecret() {
        return secret;
    }

    public String getServer() {
        return server;
    }

    public int getFarm() {
        return farm;
    }

    public String getTitle() {
        return title;
    }

    public boolean isPublic() {
        return ispublic == 1;
    }

    public boolean isFamily() {
        return isfamily == 1;
    }

    public String getUrlMedium() {
        Preconditions.checkEmptyString(url_m, "To get this url, you should pass the parameter " + Extras.UrlMedium);
        return url_m;
    }

    public int getHeightMedium() {
        Preconditions.checkEmptyString(url_m, "To get this height, you should pass the parameter " + Extras.UrlMedium);
        return height_m;
    }

    public int getWithMedium() {
        Preconditions.checkEmptyString(url_m, "To get this width, you should pass the parameter " + Extras.UrlMedium);
        return width_m;
    }


    public String getPhotoUrl() {
        // http://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg
        StringBuilder builder = new StringBuilder("http://farm");
        builder.append(farm)
                .append(".staticflickr.com/")
                .append(server).append("/").append(id).append("_").append(secret).append("jpg");
        return builder.toString();
    }
}
