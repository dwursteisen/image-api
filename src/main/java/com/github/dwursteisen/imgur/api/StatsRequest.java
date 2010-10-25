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

package com.github.dwursteisen.imgur.api;

import com.github.dwursteisen.imgur.request.Request;

import java.util.HashMap;
import java.util.Map;

public class StatsRequest implements Request {


    private String view;

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String createServiceUrl(String baseUrl) {
        return baseUrl + "stats";
    }

    public Map<String, Object> buildParameters() {
        return new HashMap();
    }
}
