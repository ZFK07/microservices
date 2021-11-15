package com.microservice.moviecatalogservice.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class CatalogItem {
        private String name;
        private String desc;
        private int rating;
}
