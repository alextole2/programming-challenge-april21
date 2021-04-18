package com.movies.api.core.enums;


public enum ErrorType {

    FILE_UPLOADED_IS_NOT_AVAILABLE_FILE(1, "File uploaded its not an available file.");

    private final int code;
    private final String message;

    ErrorType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
