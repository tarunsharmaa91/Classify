package com.app.classify.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ResultsTest {

    private final String created_at = "2019-02-24 04:04:17.566515";
    private final String price = "AED 5";
    private final String name = "Notebook";
    private final String uid = "4878bf592579410fba52941d00b62f94";

    @Mock
    Results results;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.when(results.getCreated_at()).thenReturn(created_at);
        Mockito.when(results.getPrice()).thenReturn(price);
        Mockito.when(results.getName()).thenReturn(name);
        Mockito.when(results.getUid()).thenReturn(uid);
    }

    @Test
    public void testName() {
        Mockito.when(results.getName()).thenReturn(name);
        Assert.assertEquals("Notebook", results.getName());
    }

    @Test
    public void testPrice() {
        Mockito.when(results.getPrice()).thenReturn(price);
        Assert.assertEquals("AED 5", results.getPrice());
    }

    @Test
    public void testUid() {
        Mockito.when(results.getUid()).thenReturn(uid);
        Assert.assertEquals("4878bf592579410fba52941d00b62f94", results.getUid());
    }

    @Test
    public void testCreatedAt() {
        Mockito.when(results.getCreated_at()).thenReturn(created_at);
        Assert.assertEquals("2019-02-24 04:04:17.566515", results.getCreated_at());
    }
}
