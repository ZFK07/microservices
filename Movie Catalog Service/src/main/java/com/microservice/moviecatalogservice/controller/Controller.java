package com.microservice.moviecatalogservice.controller;

import com.microservice.moviecatalogservice.service.CatalogItem;
import com.microservice.moviecatalogservice.service.Movie;
import com.microservice.moviecatalogservice.service.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class Controller {
        @Autowired
        private RestTemplate restTemplate;

        @Autowired
        private WebClient.Builder webClientBuilder;

        @Bean
        public RestTemplate getRestTemplate() {
                return new RestTemplate();
        }

        @Bean
        public WebClient.Builder getWebClient() {
                return WebClient.builder();
        }

        @RequestMapping("/{userId}")
        public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
                final List<Rating> ratings = Arrays.asList(new Rating("Prisoner", 4), new Rating("American Pie", 5));
                return ratings.stream().map(rating -> {

                        final Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/" + rating.getMovieId()).retrieve().bodyToMono(Movie.class).block();

//                        final Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
                        return new CatalogItem(movie.getName(), "awesome", 4);
                }).collect(Collectors.toList());
        }
}
