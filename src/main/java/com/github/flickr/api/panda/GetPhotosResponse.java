package com.github.flickr.api.panda;

import com.github.flickr.api.commons.FlickrResponse;
import com.github.flickr.api.model.Photo;

import java.util.List;

/**
 * User: Wursteisen David
 * Date: 29/02/12
 * Time: 21:48
 */
public class GetPhotosResponse extends FlickrResponse {

    /*
    {"photos":{
        "photo":[{"title":"FhameDaphne", "id":"5240423260", "secret":"69361076e9", "server":"5281", "farm":6, "owner":"37129033@N06", "ownername":"F A M E", "latitude":21.118932, "longitude":-101.67572, "accuracy":"11"}],
        "interval":60,
        "lastupdate":1330550210,
        "total":99,
        "panda":"wang wang"},
     "stat":"ok"}
     */

    private static class Photos {
        private String panda;
        private int total;
        private long lastupdate;
        private int interval;
        private List<Photo> photo;

    }

    private Photos photos;
    private String stat;

    public String getStat() {
        return stat;
    }

    public List<Photo> getPhotos() {
        return photos.photo;
    }

    public int getInterval() {
        return photos.interval;
    }

    public long getLastUpdate() {
        return photos.lastupdate;
    }

    public int getTotal() {
        return photos.total;
    }

    public Panda getPanda() {
        return Panda.fromValue(photos.panda);
    }
}
