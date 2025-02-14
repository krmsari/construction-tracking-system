package com.kerem.authservice.exception.abstracts;

public abstract class BaseException extends RuntimeException {

    private final ErrorCode errorCode;


    protected BaseException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
