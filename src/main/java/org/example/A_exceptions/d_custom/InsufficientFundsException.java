package org.example.A_exceptions.d_custom;

// Custom checked exception: extends Exception.
// Compiler forces callers to catch it or declare throws.
// (Extend RuntimeException instead for an unchecked exception.)

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
