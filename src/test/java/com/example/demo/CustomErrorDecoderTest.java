package com.example.demo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import feign.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springdoc.api.OpenApiResourceNotFoundException;

public class CustomErrorDecoderTest {
    @Test
    public void testDecodeUnauthorized() {
        CustomErrorDecoder decoder = new CustomErrorDecoder();
        Response response = mock(Response.class);
        when(response.status()).thenReturn(HttpStatus.SC_UNAUTHORIZED);

        Exception exception = decoder.decode("test", response);

        assertTrue(exception instanceof OpenApiResourceNotFoundException);
        assertEquals("You might want to authorize first", exception.getMessage());
    }

    @Test
    public void testDecodeInternalServerError() {
        CustomErrorDecoder decoder = new CustomErrorDecoder();
        Response response = mock(Response.class);
        when(response.status()).thenReturn(HttpStatus.SC_INTERNAL_SERVER_ERROR);

        Exception exception = decoder.decode("test", response);

        assertTrue(exception instanceof OpenApiResourceNotFoundException);
        assertEquals("server error????", exception.getMessage());
    }

    @Test
    public void testDecodeNotFound() {
        CustomErrorDecoder decoder = new CustomErrorDecoder();
        Response response = mock(Response.class);
        when(response.status()).thenReturn(HttpStatus.SC_NOT_FOUND);

        Exception exception = decoder.decode("test", response);

        assertTrue(exception instanceof OpenApiResourceNotFoundException);
        assertEquals("This is not the page you are looking for", exception.getMessage());
    }

    @Test
    public void testDecodeUnexpectedError() {
        CustomErrorDecoder decoder = new CustomErrorDecoder();
        Response response = mock(Response.class);
        when(response.status()).thenReturn(HttpStatus.SC_BAD_REQUEST);

        Exception exception = decoder.decode("test", response);

        assertTrue(exception instanceof OpenApiResourceNotFoundException);
        assertEquals("An unexpected error occurred: " + HttpStatus.SC_BAD_REQUEST, exception.getMessage());
    }
}
