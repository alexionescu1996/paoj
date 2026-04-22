package org.example.payments.propagation;

public class PaymentGatewayException extends Exception {
    public PaymentGatewayException(String message, Throwable cause) {
        super(message, cause);
    }
}
