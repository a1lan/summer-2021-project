package com.family_server;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.concurrent.atomic.AtomicLong;

import com.family_server.model.TestResponse;

public class TestResponseTest {
    @Test
    public void test1() throws Exception {
        String expectedValue = "Hello!";
        AtomicLong counter = new AtomicLong();
        Long expectedLong = counter.incrementAndGet();
        TestResponse tr = new TestResponse(expectedLong, expectedValue);
        assertTrue(tr.getId() == expectedLong);
        assertTrue(tr.getContent().equals(expectedValue));
    }
}