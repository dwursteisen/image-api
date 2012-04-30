package com.github.flickr.api.collections;

import com.github.flickr.api.commons.FlickrResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Wursteisen David
 * Date: 05/04/12
 * Time: 21:45
 */
public class GetTreeResponse extends FlickrResponse {

    /*
    { "collections": {
        "collection": [
          { "id": "26030969-72157623698256245", "title": "Ville 2008 2009", "description": "", "iconlarge": "http:\/\/farm3.staticflickr.com\/2703\/cols\/72157623698256245_ddc27f2cda_l.jpg", "iconsmall": "http:\/\/farm3.staticflickr.com\/2703\/cols\/72157623698256245_ddc27f2cda_s.jpg",
            "set": [
              { "id": "72157621102443443", "title": "Dense cité", "description": "" },
              { "id": "72157605987528173", "title": "Détails urbains", "description": "" },
              { "id": "72157618566239398", "title": "Ciels Urbains", "description": "" }
            ] },
          { "id": "26030969-72157623698249979", "title": "Ville 2010", "description": "", "iconlarge": "http:\/\/farm3.staticflickr.com\/2732\/cols\/72157623698249979_d0ac039d47_l.jpg", "iconsmall": "http:\/\/farm3.staticflickr.com\/2732\/cols\/72157623698249979_d0ac039d47_s.jpg",
            "set": [
              { "id": "72157623822701500", "title": "Dense Cité 2010", "description": "" },
              { "id": "72157623822670686", "title": "Ciels Urbains 2010", "description": "" },
              { "id": "72157623822693292", "title": "Détails Urbains 2010", "description": "" }
            ] }
        ] }, "stat": "ok" }
     */

    public List<CollectionEntry> getCollection() {
        return collections.collection;
    }

    public String getStat() {
        return stat;
    }

    private Collections collections;
    private String stat;

    private static class Collections {
        private List<CollectionEntry> collection = new ArrayList<CollectionEntry>();
    }

    public static class CollectionEntry {
        private String id;
        private String title;
        private String description;
        private String iconlarge;
        private String iconsmall;
        private List<SetEntry> set = new ArrayList<SetEntry>();

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getIconlarge() {
            return iconlarge;
        }

        public String getIconsmall() {
            return iconsmall;
        }

        public List<SetEntry> getSet() {
            return set;
        }
    }

    public static class SetEntry {
        private String id;
        private String title;
        private String description;

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }
    }

}
