package com.travellodge.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@ControllerAdvice
public class ControllerAdvisor {

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<Object> handleUserNotFoundException(final UserNotFoundException ex,
                                                            final WebRequest request) {
    Map<String, Object> body = buildCommonMessageBody(ex.getMessage());
    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(UserAlreadyInException.class)
  public ResponseEntity<Object> handleUserAlreadyInException(final UserNotFoundException ex,
                                                            final WebRequest request) {
    Map<String, Object> body = buildCommonMessageBody(ex.getMessage());
    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }

  /**
   * Build common message body
   *
   * @param message exception message
   * @return Message body
   */
  private Map<String, Object> buildCommonMessageBody(final String message) {
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message", message);
    return body;
  }

}
