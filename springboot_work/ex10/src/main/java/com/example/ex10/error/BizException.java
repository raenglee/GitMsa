package com.example.ex10.error;

import lombok.Getter;

@Getter
public class BizException extends RuntimeException{

    private final ErrorCode errorCode;

    public BizException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
