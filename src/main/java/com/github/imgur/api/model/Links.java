package com.github.imgur.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * User: Wursteisen David
 * Date: 24/03/12
 * Time: 14:05
 */
public class Links {
    private String original;
    @SerializedName("imgur_page")
    private String imgurPage;
    @SerializedName("small_square")
    private String smallSquare;
    @SerializedName("lage_thumbnail")
    private String largeThumbnail;
    @SerializedName("delete_page")
    private String deletePage;

    public String getOriginal() {
        return original;
    }

    public String getImgurPage() {
        return imgurPage;
    }

    public String getSmallSquare() {
        return smallSquare;
    }

    public String getLargeThumbnail() {
        return largeThumbnail;
    }

    public String getDeletePage() {
        return deletePage;
    }
}
