package com.github.flickr.api.test;

import com.github.flickr.api.commons.FlickrResponse;

/**
 * User: Wursteisen David
 * Date: 29/02/12
 * Time: 21:34
 *
 * @see <a href="http://www.flickr.com/services/api/flickr.test.null.html">flickr.test.null</a>
 */
public class NullResponse extends FlickrResponse {

    /*
    {"stat":"ok"}
     */

    private String stat;

    public String getStat() {
        return stat;
    }
}
