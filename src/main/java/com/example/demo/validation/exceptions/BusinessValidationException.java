package com.example.demo.validation.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessValidationException extends RuntimeException {

  private HttpMessage errorMessage;

  private HttpStatus status;

}
