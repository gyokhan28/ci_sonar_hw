package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MovieController.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieClient movieClient;

    @Test
    public void testFindMovie() throws Exception {
        MovieSearchResponse response = new MovieSearchResponse();
        when(movieClient.findMovie("test")).thenReturn(response);

        mockMvc.perform(get("/movie")
                        .param("query", "test"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testFindMoovie() throws Exception {
        MovieSearchResponse response = new MovieSearchResponse();
        when(movieClient.findMoovie("test")).thenReturn(response);

        mockMvc.perform(get("/moovie")
                        .param("query", "test"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetFavouriteMovies() throws Exception {
        MovieSearchResponse response = new MovieSearchResponse();
        when(movieClient.getFavouriteMovies(1)).thenReturn(response);

        mockMvc.perform(get("/getfavourite/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testAddFavoriteMovie() throws Exception {
        MovieRequestDTO request = new MovieRequestDTO();
        when(movieClient.postFavoriteMovie(any(Integer.class), any(MovieRequestDTO.class))).thenReturn(request);

        mockMvc.perform(post("/add-movie/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Test Movie\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
