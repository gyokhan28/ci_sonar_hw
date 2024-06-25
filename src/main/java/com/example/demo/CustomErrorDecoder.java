package com.example.demo;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.http.HttpStatus;
import org.springdoc.api.OpenApiResourceNotFoundException;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        int status = response.status();
        switch (status){
            case HttpStatus.SC_UNAUTHORIZED: return new OpenApiResourceNotFoundException("You might want to authorize first");
            case HttpStatus.SC_INTERNAL_SERVER_ERROR: return new OpenApiResourceNotFoundException("server error????");
            case HttpStatus.SC_NOT_FOUND: return new OpenApiResourceNotFoundException("This is not the page you are looking for");
        }
        return null;
    }
}
