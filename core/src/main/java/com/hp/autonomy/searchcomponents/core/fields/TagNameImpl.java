/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.searchcomponents.core.fields;

import com.hp.autonomy.types.requests.idol.actions.tags.TagName;
import lombok.Data;

/**
 * Default implementation of {@link TagName}
 */
@Data
class TagNameImpl implements TagName {
    private static final long serialVersionUID = -6221132711228529797L;
    private final String id;
    private final String name;
}