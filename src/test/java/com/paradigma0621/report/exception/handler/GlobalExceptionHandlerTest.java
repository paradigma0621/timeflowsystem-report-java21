package com.paradigma0621.report.exception.handler;

import com.paradigma0621.report.exception.ClockingSenderRequestException;
import com.paradigma0621.report.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    @Test
    void nullPointerExceptionHandlerConstroiProblemDetailInternalServerError() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        NullPointerException ex = new NullPointerException("boom");

        ResponseEntity<ProblemDetail> response = handler.nullPointerExceptionHandler(ex);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

        ProblemDetail body = response.getBody();
        assertNotNull(body);
        assertEquals("Unexpected error", body.getTitle());
        assertEquals("boom", body.getDetail());
        assertEquals(500, body.getStatus());
    }

    @Test
    void resourceNotFoundExceptionHandlerConstroiProblemDetailNotFoundComPropriedadeCode() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        ResourceNotFoundException ex = new ResourceNotFoundException("person");

        ResponseEntity<ProblemDetail> response = handler.resourceNotFoundExceptionHandler(ex);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        ProblemDetail body = response.getBody();
        assertNotNull(body);
        assertEquals("Not found resource", body.getTitle());
        assertEquals("person", body.getDetail());
        assertEquals(404, body.getStatus());

        assertEquals(404L, body.getProperties().get("code"));
    }

    @Test
    void clockingSenderRequestExceptionHandlerConstroiProblemDetailInternalServerError() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        ClockingSenderRequestException ex = new ClockingSenderRequestException("queue offline");

        ResponseEntity<ProblemDetail> response = handler.clockingSenderRequestExceptionHandler(ex);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

        ProblemDetail body = response.getBody();
        assertNotNull(body);
        assertEquals("Clocking sender error", body.getTitle());
        assertEquals("queue offline", body.getDetail());
        assertEquals(500, body.getStatus());
    }
}
