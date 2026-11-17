package org.skypro.skyshop.exceptions;

import java.io.IOException;

public class IllegalProductTitleException extends RuntimeException {
    public IllegalProductTitleException() {
    }

    public IllegalProductTitleException(String message) {
        super(message);
    }

    public IllegalProductTitleException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalProductTitleException(Throwable cause) {
        super(cause);
    }
}
