package com.github.flickr.api.interestingness;

import com.github.commons.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Wursteisen David
 * Date: 18/02/12
 * Time: 14:20
 */
public class GetListRequest implements Request {

    /*

       http://www.flickr.com/services/api/flickr.interestingness.getList.html

        api_key (Required)
        Your API application key. See here for more details.

        date (Optional)
        A specific date, formatted as YYYY-MM-DD, to return interesting photos for.

        extras (Optional)
        A comma-delimited list of extra information to fetch for each returned record. Currently supported fields are: description, license, date_upload, date_taken, owner_name, icon_server, original_format, last_update, geo, tags, machine_tags, o_dims, views, media, path_alias, url_sq, url_t, url_s, url_m, url_z, url_l, url_o
        Number of photos to return per page. If this argument is omitted, it defaults to 100. The maximum allowed value is 500.

        page (Optional)
        The page of results to return. If this argument is omitted, it defaults to 1.
    */

    private String date;
    private String extras;
    private Integer page;

    @Override
    public String createServiceUrl(String baseUrl) {
        return baseUrl;
    }

    @Override
    public Map<String, Object> buildParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("method", "flickr.interestingness.getList");
        if (date != null) {
            parameters.put("date", date);
        }
        if (extras != null) {
            parameters.put("extras", extras);
        }
        if (page != null) {
            parameters.put("page", page);
        }
        return parameters;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
