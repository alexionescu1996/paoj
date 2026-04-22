package org.example.payments.resources;

// Implementing AutoCloseable lets an object be used in try-with-resources.
// close() runs automatically at the end of the try block, even if an
// exception is thrown - no manual finally { session.close(); } needed.

public class PaymentSession implements AutoCloseable {

    private final String gateway;
    private boolean open = true;

    public PaymentSession(String gateway) {
        this.gateway = gateway;
        System.out.println("Opened session to " + gateway);
    }

    public void charge(String cardId, double amount) {
        if (!open) {
            throw new IllegalStateException("Session already closed");
        }
        System.out.println("Charging " + amount + " on card " + cardId + " via " + gateway);
    }

    @Override
    public void close() {
        open = false;
        System.out.println("Closed session to " + gateway);
    }
}
