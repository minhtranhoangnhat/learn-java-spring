package com.example.javamvcdemo.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Undefined error!"),
    USER_EXISTED(1001, "User existed!"),
    USERNAME_INVALID(1002, "Username must be at least 3 characters!"),
    PASSWORD_INVALID(1003, "Password must be at least 8 characters!"),
    INVALID_ERROR_KEY(1004, "Invalid error key!"),
    USER_NOT_FOUND(1005, "User not found!")
    ;
    private int code;
    private String message;

    ErrorCode(int code, String message) {
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
