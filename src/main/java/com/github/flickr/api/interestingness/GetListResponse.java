package com.github.flickr.api.interestingness;

import com.github.commons.Response;
import com.github.flickr.api.commons.Extras;
import org.scribe.utils.Preconditions;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Wursteisen David
 * Date: 18/02/12
 * Time: 14:20
 */
public class GetListResponse implements Response {
    /*
    jsonFlickrApi({
        "photos":{
            "page":1,
            "pages":5,
            "perpage":100,
            "total":500,
            "photo":[
                {
                 "id":"6892914257",
                 "owner":"55237190@N00",
                 "secret":"2cf3a1af62",
                 "server":"7043",
                 "farm":8,
                 "title":"",
                 "ispublic":1,
                 "isfriend":0,
                 "isfamily":0
                 }
            ]},
        "stat":"ok"
    })
     */

    private static class Photos {
        private int page;
        private int pages;
        private int perpage;
        private int total;
        private List<Photo> photo;
    }

    public static class Photo {
        private String id;
        private String owner;
        private String secret;
        private String server;
        private int farm;
        private String title;
        private boolean ispublic;
        private boolean isfamily;
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
            return ispublic;
        }

        public boolean isFamily() {
            return isfamily;
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

    private Photos photos;
    private String stat;

    public int getPage() {
        return photos.page;
    }

    public int getPages() {
        return photos.pages;
    }

    public int getPerPage() {
        return photos.perpage;
    }

    public int getTotal() {
        return photos.total;
    }

    public String getStat() {
        return stat;
    }

    public List<Photo> getPhotos() {
        return new ArrayList<Photo>(photos.photo);
    }
}
