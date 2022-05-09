package com.doctorapp.exception;

import com.doctorapp.model.ApiErrors;
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
        details.add("Request Method Not Supported (sp)");
        ApiErrors errors = new ApiErrors(message,details,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Media Type Not Supported (sp)");
        ApiErrors errors = new ApiErrors(message,details,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Missing Path Variable (sp)");
        ApiErrors errors = new ApiErrors(message,details,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Request Param is Missing (sp)");
        ApiErrors errors = new ApiErrors(message,details,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Type Mismatch (sp)");
        ApiErrors errors = new ApiErrors(message,details,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Request Body Is Not Readable (sp)");
        ApiErrors errors = new ApiErrors(message,details,status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<Object> handleDoctorNotFoundException(DoctorNotFoundException ex ){
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Doctor Not Found (sp)");
        ApiErrors errors = new ApiErrors(message,details,HttpStatus.BAD_REQUEST, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleOtherException(DoctorNotFoundException ex ){
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Other Exception(sp)");
        ApiErrors errors = new ApiErrors(message,details,HttpStatus.BAD_REQUEST, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

}
