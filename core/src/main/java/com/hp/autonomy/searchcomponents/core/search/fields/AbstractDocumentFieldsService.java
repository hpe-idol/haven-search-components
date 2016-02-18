/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.searchcomponents.core.search.fields;

import com.hp.autonomy.frontend.configuration.ConfigService;
import com.hp.autonomy.searchcomponents.core.config.FieldInfo;
import com.hp.autonomy.searchcomponents.core.config.FieldsInfo;
import com.hp.autonomy.searchcomponents.core.config.HavenSearchCapable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class AbstractDocumentFieldsService implements DocumentFieldsService {
    protected final ConfigService<? extends HavenSearchCapable> configService;

    protected AbstractDocumentFieldsService(final ConfigService<? extends HavenSearchCapable> configService) {
        this.configService = configService;
    }

    @Override
    public List<String> getPrintFields() {
        final FieldsInfo fieldsInfo = configService.getConfig().getFieldsInfo();

        final List<String> fields = new ArrayList<>();

        for (final FieldInfo<?> field : getHardCodedFields()) {
            fields.add(field.getName());
        }

        final Set<FieldInfo<?>> customFields = fieldsInfo.getCustomFields();
        for (final FieldInfo<?> customField : customFields) {
            fields.add(customField.getName());
        }

        return fields;
    }
}