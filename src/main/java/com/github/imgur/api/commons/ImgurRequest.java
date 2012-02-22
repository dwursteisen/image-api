package com.github.imgur.api.commons;

import com.github.commons.Request;
import org.scribe.model.Verb;

/**
 * User: Wursteisen David
 * Date: 22/02/12
 * Time: 21:43
 */
public abstract class ImgurRequest implements Request {

    public abstract String requestUrl(String baseUrl);

    public Verb getVerb() {
        return Verb.POST;
    }
}
