package com.app.classify.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class ClassifyAdTest {

    private final List<Results> results = new ArrayList<>();

    @Mock
    ClassifyAd classifyAd;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.when(classifyAd.getResults()).thenReturn(results);
    }

    @Test
    public void testAdList() {
        Mockito.when(classifyAd.getResults()).thenReturn(results);
        Assert.assertEquals(new ArrayList<>(), classifyAd.getResults());
    }

    @Test
    public void testAdListIncorrect() {
        Mockito.when(classifyAd.getResults()).thenReturn(results);
        Assert.assertNotEquals("", classifyAd.getResults());
    }

}
