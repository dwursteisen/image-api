/*
 * Copyright (C) 2010 David Wursteisen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.imgur.api.stats;

import com.github.imgur.api.commons.ImgurRequest;
import org.scribe.model.Verb;

import java.util.HashMap;
import java.util.Map;

public class StatsRequest extends ImgurRequest {

    public StatsRequest() {
        throw new RuntimeException("Oups ! This request is no more working on imgur...");
    }

    private String view;

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public Map<String, Object> buildParameters() {
        return new HashMap();
    }

    @Override
    public boolean isOAuth() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Verb getVerb() {
        return Verb.GET;
    }

    @Override
    public String requestUrl(String baseUrl) {
        return baseUrl + "stats.json";
    }
}
