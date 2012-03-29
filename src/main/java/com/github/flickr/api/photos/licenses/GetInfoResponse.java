package com.github.flickr.api.photos.licenses;

import com.github.flickr.api.commons.FlickrResponse;

import java.util.List;

/**
 * User: Wursteisen David
 * Date: 30/03/12
 * Time: 00:06
 */
public class GetInfoResponse extends FlickrResponse {
    /*
    { "licenses": {
    "license": [
      { "id": 0, "name": "All Rights Reserved", "url": "" },
      { "id": 4, "name": "Attribution License", "url": "http:\/\/creativecommons.org\/licenses\/by\/2.0\/" },
      { "id": 6, "name": "Attribution-NoDerivs License", "url": "http:\/\/creativecommons.org\/licenses\/by-nd\/2.0\/" },
      { "id": 3, "name": "Attribution-NonCommercial-NoDerivs License", "url": "http:\/\/creativecommons.org\/licenses\/by-nc-nd\/2.0\/" },
      { "id": 2, "name": "Attribution-NonCommercial License", "url": "http:\/\/creativecommons.org\/licenses\/by-nc\/2.0\/" },
      { "id": 1, "name": "Attribution-NonCommercial-ShareAlike License", "url": "http:\/\/creativecommons.org\/licenses\/by-nc-sa\/2.0\/" },
      { "id": 5, "name": "Attribution-ShareAlike License", "url": "http:\/\/creativecommons.org\/licenses\/by-sa\/2.0\/" },
      { "id": 7, "name": "No known copyright restrictions", "url": "http:\/\/www.flickr.com\/commons\/usage\/" },
      { "id": 8, "name": "United States Government Work", "url": "http:\/\/www.usa.gov\/copyright.shtml" }
    ] }, "stat": "ok" }
     */
    public static class License {
        private int id;
        private String name;
        private String url;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }

    private static class Licenses {
        private List<License> license;
    }

    private Licenses licenses;
    private String stat;

    public String getStat() {
        return stat;
    }

    public List<License> getLicenses() {
        return licenses.license;
    }
}
