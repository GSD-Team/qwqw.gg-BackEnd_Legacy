package com.gsd.fifa4.global.error;

import lombok.Getter;

/**
 * Created by Yohan lee
 * Created on 2021-02-01.
 **/

@Getter
public class ErrorResponse {
    private final String message;

    private Object resultData;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public ErrorResponse(String message, Object resultData) {
        this.message = message;
        this.resultData = resultData;
    }
}
