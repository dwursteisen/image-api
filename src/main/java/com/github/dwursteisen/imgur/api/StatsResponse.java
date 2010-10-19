package com.github.dwursteisen.imgur.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 19 oct. 2010
 * Time: 23:33:18
 * To change this template use File | Settings | File Templates.
 */
/*
{
    "stats": {
        "most_popular_images": ["gn2gN", "cXQqZ", "JiPqw", "WdRim", "zPxWo"],
        "images_uploaded": 1627648,
        "images_veiwed": 1080303365,
        "bandwidth_used": "4.58 TB",
        "average_image_size": "40.74 KB"
    }
}
*/

public class StatsResponse {

    static private class Stats {
        @SerializedName("most_popular_images")
        private String[] mostPopularImages;

        @SerializedName("images_uploaded")
        private int imagesUploaded;

        @SerializedName("images_veiwed")
        private int imagesViewed;

        @SerializedName("bandwidth_used")
        private String bandwidthUsed;

        @SerializedName("average_image_size")
        private String averageImageSize;

        public Stats() {

        }
    }

    @SerializedName("stats")
    private Stats stats = new Stats();

    public String getAverageImageSize() {
        return stats.averageImageSize;
    }

    public void setAverageImageSize(String averageImageSize) {
        this.stats.averageImageSize = averageImageSize;
    }

    public String getBandwidthUsed() {
        return stats.bandwidthUsed;
    }

    public void setBandwidthUsed(String bandwidthUsed) {
        this.stats.bandwidthUsed = bandwidthUsed;
    }

    public String[] getMostPopularImages() {
        return stats.mostPopularImages;
    }

    public void setMostPopularImages(String[] mostPopularImages) {
        this.stats.mostPopularImages = mostPopularImages;
    }

    public int getImagesUploaded() {
        return stats.imagesUploaded;
    }

    public void setImagesUploaded(int imagesUploaded) {
        this.stats.imagesUploaded = imagesUploaded;
    }

    public int getImagesViewed() {
        return stats.imagesViewed;
    }

    public void setImagesViewed(int imagesViewed) {
        this.stats.imagesViewed = imagesViewed;
    }
}
