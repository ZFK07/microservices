package io.microservice.rating.controller;

import io.microservice.rating.service.CatalogItem;
import io.microservice.rating.service.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class Controller {

        @GetMapping("/{userId}")
        public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
                List<Rating> ratingsList = Arrays.asList(
                        new Rating("1234", 3),
                        new Rating("5678", 4)
                );

                return ratingsList.stream()
                        .map(rating -> new CatalogItem("Name", "Desc", rating.getRating()))
                        .collect(Collectors.toList());

        }
}
