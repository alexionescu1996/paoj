package org.example.A_exceptions.e_propagation;

import java.io.IOException;

// throw  - statement that raises an exception.
// throws - method clause declaring checked exceptions it may propagate.
// Propagation: an unhandled exception travels up the call stack until
// some caller catches it.
//
// main -> checkout -> authorize (throws) -> caught in main

public class Ex {
    public static void main(String[] args) {
        try {
            checkout(199.99);
        } catch (IOException e) {
            System.out.println("Caught in main: " + e.getMessage());
        }
    }

    static void checkout(double amount) throws IOException {
        authorize(amount);   // not caught here - propagates
    }

    static void authorize(double amount) throws IOException {
        throw new IOException("bank timeout for " + amount);
    }
}
