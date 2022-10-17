package com.udacity.bootstrap.responses;

import lombok.Data;
import java.util.List;

@Data
public class AllAnimesResponse {
    private boolean success;
    private List<Anime> data;
}
