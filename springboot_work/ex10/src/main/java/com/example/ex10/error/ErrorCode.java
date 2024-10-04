package com.example.ex10.error;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    //Ctrl+shift+x 번역해줌 ㅎㅎ
    DUPLICATE_USERS(HttpStatus.BAD_REQUEST,"email 중복입니다"),
    NOT_FOUND(HttpStatus.BAD_REQUEST,"해당되는 게시물이 없습니다"),
    ;

    private HttpStatus httpStatus;
    private String message;

    ErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}