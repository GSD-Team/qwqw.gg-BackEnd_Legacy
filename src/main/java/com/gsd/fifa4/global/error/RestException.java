package com.gsd.fifa4.global.error;

import lombok.Getter;
import org.springframework.http.ResponseEntity;

/**
 * Created by Yohan lee
 * Created on 2021-03-04.
 **/

@Getter
public class RestException extends RuntimeException {


    private final Object errorBody;

    public RestException(String message, Object body) {
        super(message);
        this.errorBody = body;
    }

}
