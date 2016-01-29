package com.epam.mrymbayev.dao.exception;


public class NewsDaoException extends RuntimeException {
    public NewsDaoException() {
        super();
    }

    public NewsDaoException(String message) {
        super(message);
    }

    public NewsDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public NewsDaoException(Throwable cause) {
        super(cause);
    }
}
