package com.example.demo;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.ErrorDecoder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = FeignConfigTest.TestConfig.class)
public class FeignConfigTest {
    @Autowired
    private RequestInterceptor requestInterceptor;

    @Autowired
    private ErrorDecoder errorDecoder;

    @Test
    public void testRequestInterceptor() {
        RequestTemplate requestTemplate = new RequestTemplate();
        requestInterceptor.apply(requestTemplate);

        assertEquals("Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlOGZiMzY5YTYyOWRmN2JkMjkwY2U1YzU5ODc2OWFjOSIsInN1YiI6IjY2NjQ1ZjJhY2Y1MmFkYjFhY2UwYjI2MyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.V08SO1kJe-jYUxeKP0wm9AnQsaxzJXgdYmroSO8maGI",
                requestTemplate.headers().get("Authorization").iterator().next());
    }

    @Test
    public void testErrorDecoder() {
        assertTrue(errorDecoder instanceof CustomErrorDecoder);
    }

    @Configuration
    static class TestConfig extends FeignConfig {
        // TestConfig inherits the beans from FeignConfig
    }
}
