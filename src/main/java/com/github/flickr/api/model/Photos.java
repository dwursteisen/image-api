package com.github.flickr.api.model;

import java.util.ArrayList;
import java.util.List;

/**
* User: Wursteisen David
* Date: 26/02/12
* Time: 16:24
*/
public class Photos {
    private int page;
    private int pages;
    private int perpage;
    private int total;
    private List<Photo> photo = new ArrayList<Photo>();

    public int getPage() {
        return page;
    }

    public int getPages() {
        return pages;
    }

    public int getPerpage() {
        return perpage;
    }

    public int getTotal() {
        return total;
    }

    public List<Photo> getPhoto() {
        return photo;
    }
}
