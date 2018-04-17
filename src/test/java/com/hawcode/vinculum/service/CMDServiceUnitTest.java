package com.hawcode.vinculum.service;

import com.hawcode.vinculum.model.ContentManagedData;
import com.hawcode.vinculum.repository.CMDRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CMDServiceUnitTest {

    private Map<String, String> testMap = new HashMap<>();
    private Class<?> testType;

    @Mock
    CMDRepository cmdRepository;

    @InjectMocks
    CMDService cut;

    @Before
    public void setUp(){
        testMap.put("CI_01", "hello world");
        testMap.put("CI_02", "goodbye world");

        when(cmdRepository.getAllTextContents(anyString())).thenReturn(testMap);
    }

    @Test
    public void getCMD(){
        ContentManagedData cmd = cut.getCMD(testType, "1");
        assertEquals(cmd.getMap(), testMap);
    }
}
