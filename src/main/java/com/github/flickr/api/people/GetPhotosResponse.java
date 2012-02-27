package com.github.flickr.api.people;

import com.github.flickr.api.commons.FlickrResponse;
import com.github.flickr.api.model.Photo;
import com.github.flickr.api.model.Photos;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Wursteisen David
 * Date: 26/02/12
 * Time: 15:42
 */
public class GetPhotosResponse extends FlickrResponse {
    /*
            jsonFlickrApi({"photos":
                {"page":1,
                "pages":2,
                "perpage":100,
                "total":"200",
                "photo":[
                    { ... },
                 "stat":"ok"})
    */
    private Photos photos;
    private String stat;

    public int getPage() {
        return photos.getPage();
    }

    public int getPages() {
        return photos.getPages();
    }

    public int getPerPage() {
        return photos.getPerpage();
    }

    public int getTotal() {
        return photos.getTotal();
    }

    public String getStat() {
        return stat;
    }

    public List<Photo> getPhotos() {
        return new ArrayList<Photo>(photos.getPhoto());
    }

}
