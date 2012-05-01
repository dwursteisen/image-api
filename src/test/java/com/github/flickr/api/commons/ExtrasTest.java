package com.github.flickr.api.commons;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.github.flickr.api.commons.Extras.commaDelimited;
import static org.fest.assertions.api.Assertions.assertThat;

public class ExtrasTest {
    @Test
    public void can_generate_comma_delimited_extras() throws Exception {
        assertThat(commaDelimited(Extras.UrlSmallSquare)).matches("url_sq");
        assertThat(commaDelimited(Extras.UrlSmallSquare, Extras.OwnerName)).matches("url_sq,owner_name");
        assertThat(commaDelimited()).matches("");
        assertThat(commaDelimited((Extras) null)).matches("");
    }

    @Test
    public void can_generate_comma_delimited_extras_with_collection() throws Exception {
        List<Extras> extrasList = Arrays.asList(Extras.UrlSmallSquare, Extras.OwnerName);
        assertThat(commaDelimited(extrasList)).matches("url_sq,owner_name");
    }
}
