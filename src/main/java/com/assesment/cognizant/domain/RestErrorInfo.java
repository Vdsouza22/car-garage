package com.assesment.cognizant.domain;

import org.springframework.http.HttpStatus;

/*
 * This class populates additional detaisl in the error response.
 * @author Vinita
 */

public class RestErrorInfo {
    public final String detail;
    public final String message;
    public final HttpStatus status;

    public RestErrorInfo(Exception ex, String message , String detail,HttpStatus status) {
    	super();
        this.message = message;
        this.detail = detail;
        this.status = status;
    }
}
