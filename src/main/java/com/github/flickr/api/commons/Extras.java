package com.github.flickr.api.commons;

import java.util.Arrays;
import java.util.Collection;

public enum Extras {

    Description("description"),
    Licence("license"),
    DateUpload("date_upload"),
    DateTake("date_taken"),
    OwnerName("owner_name"),
    IconServer("icon_server"),
    OriginalFormat("original_format"),
    LastUpdate("last_update"),
    Geo("geo"),
    Tags("tags"),
    MachineTags("machine_tags"),
    OriginalDimension("o_dims"),
    Views("views"),
    Media("media"),
    PathAlias("path_alias"),
    UrlSmallSquare("url_sq"),
    UrlThumbnail("url_t"),
    UrlSmall("url_s"),
    UrlMedium("url_m"),
    UrlMoreMedium("url_z"),
    UrlLarge("url_l"),
    UrlOriginale("url_o");

    private final String extras;

    private Extras(String extras) {
        this.extras = extras;
    }

    public String getExtras() {
        return extras;
    }


    public static String commaDelimited(Extras... extras) {
        if (extras == null || extras.length == 0) {
            return "";
        }

        StringBuilder buffer = new StringBuilder();
        if (extras[0] != null) {
            buffer.append(extras[0].extras);
        }
        Extras[] subArray = Arrays.copyOfRange(extras, 1, extras.length);
        for (Extras extra : subArray) {
            if (extra == null) {
                continue;
            }
            buffer.append(",");
            buffer.append(extra.extras);
        }
        return buffer.toString();
    }

    public static String commaDelimited(Collection<Extras> extras) {
        return commaDelimited(extras.toArray(new Extras[extras.size()]));
    }
}
