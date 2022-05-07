package com.gsd.fifa4.global.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Created by Yohan lee
 * Created on 2021-02-01.
 **/

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class RestApiExceptionHandler {

    private final ObjectMapper objectMapper;

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(RestException.class)
    public ResponseEntity<?> handleRestException(RestException e) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse(e.getMessage(), e.getErrorBody()));
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<?> handleHttpClientErrorException(HttpClientErrorException e) {

        try {
            Object  errorData = objectMapper.readValue(e.getResponseBodyAsString(), Object.class);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("API communication error", errorData));
        } catch (Exception ex) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("API communication error"));
        }
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<ErrorResponse> handleMissingPathVariableException(MissingPathVariableException e) {
        ErrorResponse response =
                new ErrorResponse("잘못된 접근입니다.", "M-000");
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            sb.append("[");
            sb.append(fieldError.getField());
            sb.append("](은)는 ");
            sb.append(fieldError.getDefaultMessage());
            sb.append(" 입력된 값: [");
            sb.append(fieldError.getRejectedValue());
            sb.append("]");
        }
        ErrorResponse response = new ErrorResponse(sb.toString(), "V-000");

        return ResponseEntity.badRequest().body(response);
    }

}
