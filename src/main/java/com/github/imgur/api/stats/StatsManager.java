package com.github.imgur.api.stats;

import com.github.commons.ProviderRequestGenerator;
import com.github.commons.RequestManager;

/**
 * User: Wursteisen David
 * Date: 22/02/12
 * Time: 21:17
 */
public class StatsManager extends RequestManager<StatsRequest, StatsResponse> {

    public StatsManager(Class<StatsResponse> clazz, ProviderRequestGenerator provider) {
        super(clazz, provider);
    }
}
