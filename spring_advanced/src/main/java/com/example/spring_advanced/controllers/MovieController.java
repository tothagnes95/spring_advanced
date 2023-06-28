package com.example.spring_advanced.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @GetMapping("/")
    public ResponseEntity<String> getMovie () {
        String uri = "https://api.themoviedb.org/3/search/movie?query=Batman&api_key=6d767f11ddf1411abde73f9f874ee041";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
