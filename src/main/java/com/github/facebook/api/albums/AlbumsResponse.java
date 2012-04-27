package com.github.facebook.api.albums;

import com.github.facebook.api.commons.FacebookResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Wursteisen David
 * Date: 22/04/12
 * Time: 17:42
 */
public class AlbumsResponse extends FacebookResponse {

    /*
    {
       "data": [
          {
             "id": "54354353",
             "from": {
                "name": "BLaalnln",
                "id": "662643543"
             },
             "name": "Cover Photos",
             "link": "https://www.facebook.com/album.php?fbid=10150442827554554&id=6545492005&aid=333304",
             "cover_photo": "10150442826543006",
             "privacy": "everyone",
             "count": 1,
             "type": "normal",
             "created_time": "2012-01-01T19:36:41+0000",
             "updated_time": "2012-01-01T19:36:44+0000",
             "can_upload": false
          }
       ],
       "paging": {
          "previous": "https://graph.facebook.com/me/albums?access_token=AAAAfghfghfg456456EtkOpRZC8FUJ54jZBix6C22P00wTLYvq3cXaDxvyuaTvNoKURj4yJNmCX9V8RGe8DpBqIUZC5WBcByMYktWZCAZDZD&limit=25&since=1325446601&__paging_token=1054545442827547006&__previous=1",
          "next": "https://graph.facebook.com/me/albums?access_token=AAAAAAITEghMBAF3XNnxxEtkOpRZC8FUJ54jZBix6C22P00wTLYvq3cXaDxvyuaTvNoKURj4yJNmCX9V8RGe8DpBqIUZC5WBdfghjkAZDZD&limit=25&until=1200359291&__paging_token=765545454005"
       }
    }
     */
    public static class Data {
        private String id;
        private String name;
        private String link;
        private String privacy; // enum ?
        private int count;
        private String type;

        @SerializedName("can_upload")
        private boolean canUpload;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getLink() {
            return link;
        }

        public String getPrivacy() {
            return privacy;
        }

        public int getCount() {
            return count;
        }

        public String getType() {
            return type;
        }

        public boolean canUpload() {
            return canUpload;
        }
    }

    private List<Data> data = new ArrayList<Data>();

    public List<Data> getData() {
        return data;
    }
}
