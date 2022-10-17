package com.udacity.bootstrap.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.udacity.bootstrap.responses.AllAnimesResponse;
import com.udacity.bootstrap.responses.AnimeFactsResponse;

@Component
public class AnimeFactsClient {
    private static final String BASE_URL = "https://anime-facts-rest-api.herokuapp.com/api/v1/";
    private static final Logger log = LoggerFactory.getLogger(AnimeFactsClient.class);

    public static AllAnimesResponse getAllAnimes(RestTemplate restTemplate) {
        AllAnimesResponse res = restTemplate.getForObject(BASE_URL, AllAnimesResponse.class);
        log.info(res.toString());
        return res;
    }

    public static AnimeFactsResponse getFactsForAnime(RestTemplate restTemplate, String animeName) {
        AnimeFactsResponse res = restTemplate.getForObject(
            BASE_URL + "{animeName}" , AnimeFactsResponse.class, animeName);
        log.info(res.toString());
        return res;
    }
}
