package org.example.payments.d_custom;

// Checked exception: extends Exception.
// The compiler forces callers to either catch it or declare it with throws.
// Use it for recoverable, expected business conditions.

public class InsufficientFundsException extends Exception {

    private final double missing;

    public InsufficientFundsException(double missing) {
        super("Insufficient funds. Missing: " + missing);
        this.missing = missing;
    }

    public double getMissing() {
        return missing;
    }
}
