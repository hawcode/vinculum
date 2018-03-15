/*
 * ************************************************************************
 *
 *  Copyright (c) 2018. Hawcode - Diseño Atómico SL
 *
 *  This file is subject to the terms and conditions defined in
 *  file 'LICENSE.txt', which is part of this source code package.
 *
 * ************************************************************************
 */

package com.hawcode.vinculum.service;

import com.hawcode.vinculum.dao.CMSDataAccessObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public class CMSServiceTest {

    @InjectMocks
    private CMSService cut;

    @Mock
    private CMSDataAccessObject dao;

    private static final String EXPECTED_TEXT = "expectedText";

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        when(dao.findTextByContentId(anyString(), anyString())).thenReturn(EXPECTED_TEXT);
    }

    @Test
    public void findTextByContentId() {
        String expectedText = cut.findTextByContentId(anyString(),anyString());
        assertEquals(expectedText, EXPECTED_TEXT);
    }

    @Test
    public void getAllTextContents() {
        Map<String, String> testMap = new HashMap<String, String>();
        testMap.put("0", EXPECTED_TEXT);

        when(dao.getAllTextContents(anyString())).thenReturn(testMap);
        Map<String, String> expectedMap = cut.getAllTextContents(anyString());
        assertEquals(testMap, expectedMap);
        assertEquals(testMap.get("0"), EXPECTED_TEXT);
    }
}
