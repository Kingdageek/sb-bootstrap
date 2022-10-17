package com.udacity.bootstrap.exceptions;

import java.io.IOException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class BadRequestException extends IOException {
    private boolean status = false;
    private String message = "failed";
    private String data = null;
}
