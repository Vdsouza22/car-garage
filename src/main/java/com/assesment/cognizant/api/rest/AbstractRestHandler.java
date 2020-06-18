package com.assesment.cognizant.api.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.assesment.cognizant.domain.RestErrorInfo;
import com.assesment.cognizant.exception.ResourceNotFoundException;


/**
 * It contains exception mapping and other common REST API functionality
 */
@ControllerAdvice
public class AbstractRestHandler extends ResponseEntityExceptionHandler  {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());


    @ExceptionHandler(ResourceNotFoundException.class)
    public
    final ResponseEntity<RestErrorInfo> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        log.info("ResourceNotFoundException handler:" + ex.getMessage());
        RestErrorInfo errorInfo = new RestErrorInfo(ex,ex.getMessage(),request.getDescription(false),HttpStatus.NOT_FOUND);
        return new ResponseEntity<RestErrorInfo>(errorInfo,HttpStatus.NOT_FOUND);
    }

}