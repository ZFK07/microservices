package com.microservice.movieinfoservice.controller;

import com.microservice.movieinfoservice.service.Movie;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class Controller {

        @GetMapping("/{movieId}")
        public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
                return new Movie(movieId, "Name");

        }


}
