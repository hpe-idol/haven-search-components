/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.searchcomponents.core.fields;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FieldPathNormaliserTest {
    private static final String EXPECTED_NORMALISED_FIELD_PATH = "/DOCUMENT/MY_FIELD";
    private static final String EXPECTED_NORMALISED_XML_FIELD_PATH = "/DOCUMENTS/DOCUMENT/MY_FIELD1/MY_FIELD2";

    private FieldPathNormaliser fieldPathNormaliser;

    @Before
    public void setUp() {
        fieldPathNormaliser = new FieldPathNormaliserImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullArg() {
        fieldPathNormaliser.normaliseFieldPath(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyArg() {
        fieldPathNormaliser.normaliseFieldPath("");
    }

    @Test
    public void normalisedFullPathIdx() {
        assertEquals(EXPECTED_NORMALISED_FIELD_PATH, fieldPathNormaliser.normaliseFieldPath("/DOCUMENT/MY_FIELD"));
    }

    @Test
    public void fullPathIdx() {
        assertEquals(EXPECTED_NORMALISED_FIELD_PATH, fieldPathNormaliser.normaliseFieldPath("DOCUMENT/MY_FIELD"));
    }

    @Test
    public void nameWithSlashIdx() {
        assertEquals(EXPECTED_NORMALISED_FIELD_PATH, fieldPathNormaliser.normaliseFieldPath("/MY_FIELD"));
    }

    @Test
    public void nameOnlyIdx() {
        assertEquals(EXPECTED_NORMALISED_FIELD_PATH, fieldPathNormaliser.normaliseFieldPath("MY_FIELD"));
    }

    @Test
    public void normalisedFullPathXml() {
        assertEquals(EXPECTED_NORMALISED_XML_FIELD_PATH, fieldPathNormaliser.normaliseFieldPath("/DOCUMENTS/DOCUMENT/MY_FIELD1/MY_FIELD2"));
    }

    @Test
    public void fullPathXml() {
        assertEquals(EXPECTED_NORMALISED_XML_FIELD_PATH, fieldPathNormaliser.normaliseFieldPath("DOCUMENTS/DOCUMENT/MY_FIELD1/MY_FIELD2"));
    }

    @Test
    public void nameWithSlashXml() {
        assertEquals("/DOCUMENT/MY_FIELD1/MY_FIELD2", fieldPathNormaliser.normaliseFieldPath("/MY_FIELD1/MY_FIELD2"));
    }

    @Test
    public void nameOnlyXml() {
        assertEquals("/DOCUMENT/MY_FIELD1/MY_FIELD2", fieldPathNormaliser.normaliseFieldPath("MY_FIELD1/MY_FIELD2"));
    }
}
