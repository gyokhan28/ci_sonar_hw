package com.example.demo;

import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
           requestTemplate.header("Authorization",
                   "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlOGZiMzY5YTYyOWRmN2JkMjkwY2U1YzU5ODc2OWFjOSIsInN1YiI6IjY2NjQ1ZjJhY2Y1MmFkYjFhY2UwYjI2MyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.V08SO1kJe-jYUxeKP0wm9AnQsaxzJXgdYmroSO8maGI");};
    }
    @Bean public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder(); }

}
