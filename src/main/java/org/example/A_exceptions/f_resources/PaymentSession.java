package org.example.A_exceptions.f_resources;

// Implementing AutoCloseable lets an object be used in try-with-resources.
// close() will be called automatically at the end of the try block.

public class PaymentSession implements AutoCloseable {

    public PaymentSession() {
        System.out.println("Session opened.");
    }

    public void charge(double amount) {
        System.out.println("Charging " + amount);
    }

    @Override
    public void close() {
        System.out.println("Session closed.");
    }
}
