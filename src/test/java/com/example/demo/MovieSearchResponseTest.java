package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MovieSearchResponseTest {

    @Test
    public void testNoArgsConstructor() {
        MovieSearchResponse response = new MovieSearchResponse();
        assertNotNull(response);
    }

    @Test
    public void testAllArgsConstructor() {
        List<Movie> movies = new ArrayList<>();
        MovieSearchResponse response = new MovieSearchResponse(1, movies, 10, 100);

        assertEquals(1, response.getPage());
        assertEquals(movies, response.getResults());
        assertEquals(10, response.getTotal_pages());
        assertEquals(100, response.getTotal_results());
    }

    @Test
    public void testSettersAndGetters() {
        MovieSearchResponse response = new MovieSearchResponse();

        response.setPage(2);
        assertEquals(2, response.getPage());

        List<Movie> movies = new ArrayList<>();
        response.setResults(movies);
        assertEquals(movies, response.getResults());

        response.setTotal_pages(20);
        assertEquals(20, response.getTotal_pages());

        response.setTotal_results(200);
        assertEquals(200, response.getTotal_results());
    }
}
