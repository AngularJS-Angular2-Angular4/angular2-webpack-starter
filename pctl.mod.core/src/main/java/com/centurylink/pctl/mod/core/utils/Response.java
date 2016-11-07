package com.centurylink.pctl.mod.core.utils;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {

    private T content;
    private String message;
    private List<String> fieldStatus;
    private String code;
    private HttpStatus httpStatus;

    public Response() {
    }

    public Response(String code, String message, HttpStatus httpStatus) {
        this.message = message;
        this.code = code;

        this.httpStatus = httpStatus;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public void setStatus(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();

        this.httpStatus = statusCode.getHttpStatus();
    }

    public String getMessage() {
        return message;
    }

    public List<String> getFieldStatus() {
        return fieldStatus;
    }

    public String getCode() {
        return code;
    }

    @JsonIgnore
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }


    public void addMessage(String message) {
        if (fieldStatus == null) {
            fieldStatus = new ArrayList<>();
        }
        fieldStatus.add(message);
    }

}
