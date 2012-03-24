package com.github.imgur.api.model;

/**
 * User: Wursteisen David
 * Date: 24/03/12
 * Time: 14:14
 */
public class ImageProperty {
    /*
    {
    "image": {
        "image": {
            "title": null,
            "caption": null,
            "hash": "yPdcE",
            "datetime": "2010-08-16 20:13:27",
            "type": "image\/gif",
            "animated": "false",
            "width": 314,
            "height": 115,
            "size": 4413,
            "views": 0,
            "bandwidth": 0
        },
        "links": {
            "original": "http:\/\/imgur.com\/yPdcE.gif",
            "imgur_page": "http:\/\/imgur.com\/yPdcE",
            "small_square": "http:\/\/imgur.com\/yPdcEs.jpg",
            "large_thumbnail": "http:\/\/imgur.com\/yPdcEl.jpg"
        }
    }
    }
    */
    private Image image;
    private Links links;

    public Image getImage() {
        return image;
    }

    public Links getLinks() {
        return links;
    }
}
