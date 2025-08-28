package org.harsha.springbootinaction.exception;

import io.micrometer.common.lang.Nullable;
import jakarta.annotation.Nonnull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.harsha.springbootinaction.dto.ErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      @Nullable HttpHeaders headers,
      @Nonnull HttpStatusCode status,
      @Nonnull WebRequest request) {
    Map<String, String> validationErrors = new HashMap<>();
    List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

    validationErrorList.forEach(
        error -> {
          String fieldName = ((FieldError) error).getField();
          String validationMsg = error.getDefaultMessage();
          validationErrors.put(fieldName, validationMsg);
        });
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new ErrorResponseDto("validation error", validationErrors));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponseDto> handleException(Exception ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(
            new ErrorResponseDto(
                "an unexcepted error occurred" + ex.getMessage(), new HashMap<>()));
  }
}
