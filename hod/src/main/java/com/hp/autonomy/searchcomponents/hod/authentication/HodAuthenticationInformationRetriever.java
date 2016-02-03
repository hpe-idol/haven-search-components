/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.searchcomponents.hod.authentication;

import com.hp.autonomy.hod.sso.HodAuthentication;
import com.hp.autonomy.searchcomponents.core.authentication.AuthenticationInformationRetriever;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class HodAuthenticationInformationRetriever implements AuthenticationInformationRetriever<HodAuthentication> {
    @Override
    public HodAuthentication getAuthentication() {
        return (HodAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }
}