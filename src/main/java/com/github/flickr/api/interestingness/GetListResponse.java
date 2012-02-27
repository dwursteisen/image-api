package com.github.flickr.api.interestingness;

import com.github.flickr.api.commons.FlickrResponse;
import com.github.flickr.api.model.Photo;
import com.github.flickr.api.model.Photos;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Wursteisen David
 * Date: 18/02/12
 * Time: 14:20
 */
public class GetListResponse extends FlickrResponse {
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
