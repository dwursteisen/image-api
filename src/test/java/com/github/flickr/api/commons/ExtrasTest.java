package com.github.flickr.api.commons;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExtrasTest {
    @Test
    public void can_generate_comma_delimited_extras() throws Exception {
        assertEquals("url_sq", Extras.commaDelimited(Extras.UrlSmallSquare));
        assertEquals("url_sq,owner_name", Extras.commaDelimited(Extras.UrlSmallSquare, Extras.OwnerName));
        assertEquals("", Extras.commaDelimited());
        assertEquals("", Extras.commaDelimited((Extras) null));
    }

    @Test
    public void can_generate_comma_delimited_extras_with_collection() throws Exception {
        List<Extras> extrasList = new ArrayList<Extras>();
        extrasList.add(Extras.UrlSmallSquare);
        extrasList.add(Extras.OwnerName);
        assertEquals("url_sq,owner_name", Extras.commaDelimited(extrasList));
    }
}
