package org.example.payments.b_trycatch;

// try-catch: wrap code that may fail, and handle the exception
// instead of letting the program crash.
//
//     try   { risky code }
//     catch (SomeException e) { recovery code }
//
// The caught exception object (e) gives us a message and a stack trace.

public class Ex {
    public static void main(String[] args) {

        Card card = new Card("1234567812345678", 50.0);

        // Without try-catch: an uncaught exception terminates the program.
        // With try-catch: we handle it and keep running.

        try {
            card.charge(120.0);
            System.out.println("Charged successfully.");
        } catch (IllegalStateException e) {
            System.out.println("Charge failed: " + e.getMessage());
        }

        // The program keeps running after the caught exception.
        try {
            card.charge(30.0);
            System.out.println("Charged 30. Remaining: " + card.getBalance());
        } catch (IllegalStateException e) {
            System.out.println("Charge failed: " + e.getMessage());
        }

        System.out.println("Program continues normally.");
    }
}
