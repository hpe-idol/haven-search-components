/*
 * (c) Copyright 2015 Micro Focus or one of its affiliates.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Micro Focus and its affiliates
 * and licensors ("Micro Focus") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Micro Focus shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
 */

package com.hp.autonomy.searchcomponents.core.search;

import com.hp.autonomy.searchcomponents.core.requests.SimpleRequestObjectTest;

import java.io.IOException;

public class TypedStateTokenTest extends SimpleRequestObjectTest<TypedStateToken> {
    @Override
    protected String json() throws IOException {
        return "{\"state_token\": \"0-ABC\", \"type\": \"QUERY\"}";
    }

    @Override
    protected TypedStateToken constructObject() {
        return new TypedStateToken("0-ABC", TypedStateToken.StateTokenType.QUERY);
    }

    @Override
    protected String toStringContent() {
        return "stateToken";
    }
}
