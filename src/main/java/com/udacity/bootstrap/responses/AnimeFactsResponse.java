package com.udacity.bootstrap.responses;

import lombok.Data;
import java.util.List;

@Data
public class AnimeFactsResponse {
    private boolean success;
    private int total_facts;
    private String anime_img;
    private List<AnimeFact> data;
}
