package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    private final MovieClient movieClient;

    @Autowired
    public MovieController(MovieClient movieClient) {
        this.movieClient = movieClient;
    }

    @GetMapping("/movie")
    public ResponseEntity<MovieSearchResponse> findMovie(@RequestParam("query") String query){
        MovieSearchResponse movieSearchResponse = movieClient.findMovie(query);
        return ResponseEntity.ok(movieSearchResponse);
    }
    @GetMapping("/moovie")
    public ResponseEntity<MovieSearchResponse> findMoovie(@RequestParam("query") String query){
        MovieSearchResponse movieSearchResponse = movieClient.findMoovie(query);
        return ResponseEntity.ok(movieSearchResponse);
    }

    @GetMapping("/getfavourite/{id}")
    public ResponseEntity<MovieSearchResponse> getFavouriteMovies(@PathVariable int id){
        MovieSearchResponse response = movieClient.getFavouriteMovies(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add-movie/{account_id}")
    public ResponseEntity<MovieRequestDTO> addFavoriteMovie(@PathVariable int account_id, @RequestBody MovieRequestDTO movieRequestDTO){
        MovieRequestDTO response = movieClient.postFavoriteMovie(account_id, movieRequestDTO);
        return ResponseEntity.ok(response);
    }
}
