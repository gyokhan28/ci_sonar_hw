package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "movieClient", url = "https://api.themoviedb.org", configuration = FeignConfig.class)
public interface MovieClient {
    @GetMapping("/3/search/movie")
    MovieSearchResponse findMovie(@RequestParam("query") String query);

    @GetMapping("/3/search/moovie")
    MovieSearchResponse findMoovie(@RequestParam("query") String query);

    @GetMapping("/3/account/{account_id}/favorite/movies")
    MovieSearchResponse getFavouriteMovies(@PathVariable int account_id);

    @PostMapping("/3/account/{account_id}/favorite")
    MovieRequestDTO postFavoriteMovie(@PathVariable int account_id, @RequestBody MovieRequestDTO movieRequestDTO);
}
