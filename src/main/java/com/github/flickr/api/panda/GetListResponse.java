package com.github.flickr.api.panda;

import com.github.flickr.api.commons.FlickrContent;
import com.github.flickr.api.commons.FlickrResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Wursteisen David
 * Date: 29/02/12
 * Time: 21:48
 */
public class GetListResponse extends FlickrResponse {

    /*
   {"pandas":
       {"panda":[
           {"_content":"ling ling"},
           {"_content":"hsing hsing"},
           {"_content":"wang wang"}]
       },
       "stat":"ok"
    }
    */
    private static class Pandas {
        private List<FlickrContent> panda = new ArrayList<FlickrContent>();

    }

    private String stat;
    private Pandas pandas;

    public String getStat() {
        return stat;
    }

    public List<Panda> getPandas() {
        List<Panda> result = new ArrayList<Panda>(pandas.panda.size());
        for (FlickrContent content : pandas.panda) {
            result.add(Panda.fromValue(content.getContent()));
        }
        return result;
    }
}
