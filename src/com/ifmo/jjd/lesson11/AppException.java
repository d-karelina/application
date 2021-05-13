package com.ifmo.jjd.lesson11;

public class AppException extends  Exception {

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "переопределение метода";
    }
}
