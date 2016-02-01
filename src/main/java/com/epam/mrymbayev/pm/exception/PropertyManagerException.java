package com.epam.mrymbayev.pm.exception;


public class PropertyManagerException extends RuntimeException {
    public PropertyManagerException() {
        super();
    }

    public PropertyManagerException(String message) {
        super(message);
    }

    public PropertyManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public PropertyManagerException(Throwable cause) {
        super(cause);
    }
}
