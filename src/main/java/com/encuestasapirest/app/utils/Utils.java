package com.encuestasapirest.app.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Utils {

    public static ResponseEntity<String> returnInternalError(String message){
        return new ResponseEntity<>(
                "Internal Server Error. ".concat(message),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
