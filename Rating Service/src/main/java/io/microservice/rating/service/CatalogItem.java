package io.microservice.rating.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CatalogItem {
        private String name;
        private String desc;
        private int rating;
}
