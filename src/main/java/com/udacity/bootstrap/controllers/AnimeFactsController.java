package com.udacity.bootstrap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.udacity.bootstrap.responses.AllAnimesResponse;
import com.udacity.bootstrap.responses.AnimeFactsResponse;
import com.udacity.bootstrap.utils.AnimeFactsClient;

@RestController
@RequestMapping("api/v1/anime_facts")
public class AnimeFactsController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/all_animes")
    public ResponseEntity<AllAnimesResponse> getAllAnimes() {
        return new ResponseEntity<AllAnimesResponse>(
            AnimeFactsClient.getAllAnimes(restTemplate), HttpStatus.OK);
    }

    @GetMapping("/{animeName}")
    public ResponseEntity<AnimeFactsResponse> getAnimeFacts (@PathVariable("animeName") String animeName) {
        return new ResponseEntity<AnimeFactsResponse>(
            AnimeFactsClient.getFactsForAnime(restTemplate, animeName), HttpStatus.OK);
    }
}
