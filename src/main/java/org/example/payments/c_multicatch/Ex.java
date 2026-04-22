package org.example.payments.c_multicatch;

// Multiple catch blocks + finally.
//
// - A try block can have many catch blocks, ordered from most specific
//   to most general. The first matching type wins.
// - Multi-catch (catch A | B e) groups unrelated exception types that
//   share the same handling.
// - finally runs no matter what: success, caught exception, or even
//   uncaught exception. Use it for cleanup (close, log, release).

public class Ex {
    public static void main(String[] args) {
        processPayment("42.50", "USER-1");
        System.out.println("---");
        processPayment("oops", "USER-2");
        System.out.println("---");
        processPayment(null, "USER-3");
        System.out.println("---");
        processPayment("-10", "USER-4");
    }

    private static void processPayment(String rawAmount, String user) {
        System.out.println("Processing payment for " + user);
        try {
            double amount = Double.parseDouble(rawAmount);
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be positive");
            }
            System.out.println("Authorized " + amount + " for " + user);

        } catch (NumberFormatException | NullPointerException e) {
            // multi-catch: both mean "bad input"
            System.out.println("Invalid amount input: " + rawAmount);

        } catch (IllegalArgumentException e) {
            System.out.println("Business rule violated: " + e.getMessage());

        } catch (RuntimeException e) {
            // most general last - catches anything not matched above
            System.out.println("Unexpected failure: " + e);

        } finally {
            System.out.println("Audit log written for " + user);
        }
    }
}
