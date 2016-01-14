/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.searchcomponents.idol.parametricvalues;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.hp.autonomy.searchcomponents.core.parametricvalues.ParametricRequest;
import com.hp.autonomy.searchcomponents.core.search.QueryRestrictions;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Collections;
import java.util.Set;

@SuppressWarnings("FieldMayBeFinal")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonDeserialize(builder = IdolParametricRequest.Builder.class)
public class IdolParametricRequest implements ParametricRequest<String> {
    private static final long serialVersionUID = 3450911770365743948L;

    private Set<String> fieldNames = Collections.emptySet();
    @SuppressWarnings("InstanceVariableOfConcreteClass")
    private QueryRestrictions<String> queryRestrictions;

    @JsonPOJOBuilder(withPrefix = "set")
    @Setter
    @Accessors(chain = true)
    @NoArgsConstructor
    public static class Builder {
        private Set<String> fieldNames = Collections.emptySet();
        @SuppressWarnings("InstanceVariableOfConcreteClass")
        private QueryRestrictions<String> queryRestrictions;
        
        public Builder(final ParametricRequest<String> parametricRequest) {
            fieldNames = parametricRequest.getFieldNames();
            queryRestrictions = parametricRequest.getQueryRestrictions();
        }

        public IdolParametricRequest build() {
            return new IdolParametricRequest(fieldNames, queryRestrictions);
        }
    }
}
