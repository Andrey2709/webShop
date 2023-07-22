package com.example.shop.errors;


import com.example.shop.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExemptionHendler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDetails> productNotFound(ProductNotFoundException e) {
        ErrorDetails errorDetails = new ErrorDetails("Product Not Found.");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }


    @ExceptionHandler(UserNotFoundExcemption.class)
    public ResponseEntity<ErrorDetails> userNotFound(UserNotFoundExcemption e){
        ErrorDetails errorDetails = new ErrorDetails("User Not Found. Check the username and password you entered.");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }

}
