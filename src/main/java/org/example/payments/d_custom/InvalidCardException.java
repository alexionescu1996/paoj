package org.example.payments.d_custom;

// Unchecked exception: extends RuntimeException.
// The compiler does NOT force callers to handle it.
// Use it for programming errors or invalid state that should not normally happen.

public class InvalidCardException extends RuntimeException {

    public InvalidCardException(String message) {
        super(message);
    }

    public InvalidCardException(String message, Throwable cause) {
        super(message, cause);
    }
}
