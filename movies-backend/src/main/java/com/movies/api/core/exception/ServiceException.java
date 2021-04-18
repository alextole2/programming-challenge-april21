package com.movies.api.core.exception;


import com.movies.api.core.enums.ErrorType;

public class ServiceException extends RuntimeException {

    private final int code;
    private final String message;

    public ServiceException(final ErrorType errorType, final Throwable throwable) {
        super(throwable);
        this.code = errorType.getCode();
        this.message = errorType.getMessage();
    }

    public ServiceException(final ErrorType errorType) {
        this.code = errorType.getCode();
        this.message = errorType.getMessage();
    }

    public ServiceException(final Integer code, final String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
