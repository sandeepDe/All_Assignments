package com.bookapp.exception;

import com.bookapp.model.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Request Method Not Supported");
        ApiErrors apiErrors = new ApiErrors(message,details,status, LocalDateTime.now());



        return ResponseEntity.status(status).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Media Not Supported");
        ApiErrors apiErrors = new ApiErrors(message,details,status, LocalDateTime.now());



        return ResponseEntity.status(status).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Path Variable Missing");
        details.add(ex.getMessage());
        ApiErrors apiErrors = new ApiErrors(message,details,status, LocalDateTime.now());



        return ResponseEntity.status(status).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Request Param is Missing");
        ApiErrors apiErrors = new ApiErrors(message,details,status, LocalDateTime.now());



        return ResponseEntity.status(status).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("MissMatch of Type");
        ApiErrors apiErrors = new ApiErrors(message,details,status, LocalDateTime.now());



        return ResponseEntity.status(status).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Request Body is Not Readable");
        ApiErrors apiErrors = new ApiErrors(message,details,status, LocalDateTime.now());



        return ResponseEntity.status(status).body(apiErrors);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException ex){
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Book Not Found");
        ApiErrors apiErrors = new ApiErrors(message,details,HttpStatus.BAD_REQUEST, LocalDateTime.now());



        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrors);

    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<Object> handleBookNotFoundException(IdNotFoundException ex){
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Id Not Found");
        ApiErrors apiErrors = new ApiErrors(message,details,HttpStatus.BAD_REQUEST, LocalDateTime.now());



        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrors);

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleOtherException(Exception ex){
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Other Exception");
        ApiErrors apiErrors = new ApiErrors(message,details,HttpStatus.BAD_REQUEST, LocalDateTime.now());



        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrors);

    }

}
