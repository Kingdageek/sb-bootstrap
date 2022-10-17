package com.udacity.bootstrap.responses.general;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneralErrorResponse {
    private boolean status = false;
    private String message = "Failed";
    private String error = "error";
    private int errorCode = 0;
}
