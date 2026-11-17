package org.skypro.skyshop.exceptions;

public class IllegalPriceException extends RuntimeException{
    public IllegalPriceException() {
        super();
    }

    public IllegalPriceException(String message) {
        super(message);
    }

    public IllegalPriceException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalPriceException(Throwable cause) {
        super(cause);
    }

    protected IllegalPriceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
