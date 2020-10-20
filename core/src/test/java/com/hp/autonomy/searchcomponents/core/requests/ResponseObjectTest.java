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

package com.hp.autonomy.searchcomponents.core.requests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Simple abstract test class for any object returned by a HavenSearch controller endpoint complex enough to deserve a builder
 *
 * @param <O> the response object type
 * @param <B> the response object builder type
 */
public abstract class ResponseObjectTest<O extends RequestObject<O, B>, B extends RequestObjectBuilder<O, B>>
        extends SimpleResponseObjectTest<O> {
    @SuppressWarnings("ObjectEquality")
    @Test
    public void toBuilder() {
        final O copyViaBuilder = object.toBuilder().build();
        assertFalse(object == copyViaBuilder);
        assertEquals(object, copyViaBuilder);
    }
}
