package com.infect.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
public class GlobalExceptionHandler {

    private final TokenBucketLimiter limiter;

    public GlobalExceptionHandler(TokenBucketLimiter limiter) {
        this.limiter = limiter;
    }

    @ExceptionHandler
    public ResponseEntity<String> handleRateLimitExceeded(Exception e) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Too many requests");
    }

    @ExceptionHandler
    public ResponseEntity<String> handleOtherExceptions(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> checkRateLimit(long taskId, int applyCount) {
        if (limiter.isLimited(taskId, applyCount)) {
            throw new RuntimeException("Rate limit exceeded");
        }
        return ResponseEntity.ok("Request allowed");
    }
}
