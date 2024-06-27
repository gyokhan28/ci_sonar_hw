package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    @Test
    public void testNoArgsConstructor() {
        Movie movie = new Movie();
        assertNotNull(movie);
    }

    @Test
    public void testAllArgsConstructor() {
        Integer[] genreIds = {28, 12, 16};
        Movie movie = new Movie(
                true,
                "/path/to/backdrop",
                genreIds,
                12345,
                "en",
                "Original Title",
                "This is a movie overview.",
                123.45,
                "/path/to/poster",
                "2024-06-27",
                "Movie Title",
                true,
                8.9,
                9876
        );

        assertEquals(true, movie.getAdult());
        assertEquals("/path/to/backdrop", movie.getBackdrop_path());
        assertArrayEquals(genreIds, movie.getGenre_ids());
        assertEquals(12345, movie.getId());
        assertEquals("en", movie.getOriginal_language());
        assertEquals("Original Title", movie.getOriginal_title());
        assertEquals("This is a movie overview.", movie.getOverview());
        assertEquals(123.45, movie.getPopularity(), 0.01);
        assertEquals("/path/to/poster", movie.getPoster_path());
        assertEquals("2024-06-27", movie.getRelease_date());
        assertEquals("Movie Title", movie.getTitle());
        assertEquals(true, movie.isVideo());
        assertEquals(8.9, movie.getVote_average(), 0.01);
        assertEquals(9876, movie.getVote_count());
    }

    @Test
    public void testSettersAndGetters() {
        Movie movie = new Movie();

        movie.setAdult(true);
        assertEquals(true, movie.getAdult());

        movie.setBackdrop_path("/path/to/backdrop");
        assertEquals("/path/to/backdrop", movie.getBackdrop_path());

        Integer[] genreIds = {28, 12, 16};
        movie.setGenre_ids(genreIds);
        assertArrayEquals(genreIds, movie.getGenre_ids());

        movie.setId(12345);
        assertEquals(12345, movie.getId());

        movie.setOriginal_language("en");
        assertEquals("en", movie.getOriginal_language());

        movie.setOriginal_title("Original Title");
        assertEquals("Original Title", movie.getOriginal_title());

        movie.setOverview("This is a movie overview.");
        assertEquals("This is a movie overview.", movie.getOverview());

        movie.setPopularity(123.45);
        assertEquals(123.45, movie.getPopularity(), 0.01);

        movie.setPoster_path("/path/to/poster");
        assertEquals("/path/to/poster", movie.getPoster_path());

        movie.setRelease_date("2024-06-27");
        assertEquals("2024-06-27", movie.getRelease_date());

        movie.setTitle("Movie Title");
        assertEquals("Movie Title", movie.getTitle());

        movie.setVideo(true);
        assertEquals(true, movie.isVideo());

        movie.setVote_average(8.9);
        assertEquals(8.9, movie.getVote_average(), 0.01);

        movie.setVote_count(9876);
        assertEquals(9876, movie.getVote_count());
    }
}
