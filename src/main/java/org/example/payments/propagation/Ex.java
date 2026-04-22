package org.example.payments.propagation;

import java.io.IOException;

// throw vs throws vs propagation.
//
//   throw  - the statement that actually raises an exception object.
//   throws - the method signature clause that DECLARES which checked
//            exceptions a method may propagate to its caller.
//
// Propagation: if a method does not catch a thrown exception, it travels
// up the call stack until some caller catches it, or the program ends.
//
// Handle where you can do something useful. Otherwise, propagate.

public class Ex {
    public static void main(String[] args) {
        try {
            checkout("order-42", 199.99);
        } catch (PaymentGatewayException e) {
            System.out.println("Checkout failed: " + e.getMessage());
            System.out.println("Caused by: " + e.getCause());
        }
    }

    // High-level: translates low-level failure into a domain exception.
    // "Exception chaining" - we keep the original cause via the constructor.
    static void checkout(String orderId, double amount) throws PaymentGatewayException {
        try {
            authorize(amount);
        } catch (IOException e) {
            throw new PaymentGatewayException("Order " + orderId + " could not be charged", e);
        }
    }

    // Mid-level: does not handle the IOException, just declares it and
    // lets it propagate up to checkout().
    static void authorize(double amount) throws IOException {
        callBankApi(amount);
    }

    // Low-level: actually throws. Simulates a network failure.
    static void callBankApi(double amount) throws IOException {
        throw new IOException("Bank API timeout for amount " + amount);
    }
}
