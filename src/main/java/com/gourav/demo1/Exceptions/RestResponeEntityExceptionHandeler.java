package com.gourav.demo1.Exceptions;

import com.gourav.demo1.collection.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.http.HttpRequest;

@ControllerAdvice
@ResponseStatus
public class RestResponeEntityExceptionHandeler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<ErrorMessage> studentNotFound(StudentNotFound stu, WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,stu.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
