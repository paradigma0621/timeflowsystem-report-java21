package com.paradigma0621.report.exception.handler;

import com.paradigma0621.report.dto.PersonDto;
import com.paradigma0621.report.dto.ResponseDto;
import com.paradigma0621.report.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> nullPointerException(NullPointerException ex) {
        log.error("message", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error in global exception handler: " + ex.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseDto<Void>> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
        log.error("ResourceNotFoundException in handler: ", ex);

        ResponseDto<Void> response = new ResponseDto<>(
                404L,
                "Not found resource: " + ex.getMessage(),
                null
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
