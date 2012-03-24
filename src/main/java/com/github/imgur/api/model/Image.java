package com.github.imgur.api.model;

/**
 * User: Wursteisen David
 * Date: 24/03/12
 * Time: 14:06
 */
public class Image {
    private String title;
    private String caption;
    private String hash;
    private String datetime;
    private String type;
    private boolean animated;
    private int width;
    private int height;
    private long size;
    private long views;
    private long bandwidth;
    private String deletehash;

    public String getTitle() {
        return title;
    }

    public String getCaption() {
        return caption;
    }

    public String getHash() {
        return hash;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getType() {
        return type;
    }

    public boolean isAnimated() {
        return animated;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public long getSize() {
        return size;
    }

    public long getViews() {
        return views;
    }

    public long getBandwidth() {
        return bandwidth;
    }

    public String getDeletehash() {
        return deletehash;
    }
}
