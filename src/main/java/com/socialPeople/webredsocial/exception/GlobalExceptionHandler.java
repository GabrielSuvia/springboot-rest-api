package com.socialPeople.webredsocial.exception;

import com.socialPeople.webredsocial.user.constant.Constants;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.FieldError;
import java.util.AbstractMap.SimpleEntry;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {
  // validate not pass(400)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public final ResponseEntity<Map<String, String>> handleMethodArgumentNotValidEx(
      MethodArgumentNotValidException ex, WebRequest request) {
    return getMapResponseEntity(ex);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public final ResponseEntity<Map<String, String>> handleConstraintViolationEx(
      MethodArgumentNotValidException ex, WebRequest request) {
    return getMapResponseEntity(ex);
  }

  // 400
  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<SimpleEntry<String, String>> handleRuntimeException(RuntimeException ex) {
    return new ResponseEntity<>(
        new SimpleEntry<>(Constants.EXCEPTION_MESSAGE_KEY, ex.getMessage()),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<SimpleEntry<String, String>> notFoundException(NotFoundException ex) {
    return new ResponseEntity<>(
        new SimpleEntry<>(Constants.EXCEPTION_MESSAGE_KEY, ex.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(RequestNotPermitted.class)
  public ResponseEntity<SimpleEntry<String, String>> handleRateLimitException(
      RequestNotPermitted e) {
    return new ResponseEntity<>(
        new SimpleEntry<>(
            Constants.EXCEPTION_MESSAGE_KEY, "Rate limit exceeded: " + e.getMessage()),
        HttpStatus.TOO_MANY_REQUESTS);
  }

  protected ResponseEntity<Map<String, String>> getMapResponseEntity(
      MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult()
        .getAllErrors()
        .forEach(
            x -> {
              String fieldName = ((FieldError) x).getField();
              String errorMessage = x.getDefaultMessage();
              errors.put(fieldName, errorMessage);
            });
    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }
}
