package org.example.A_exceptions.c_multicatch;

// Multiple catch + finally.
// - Order catches from most specific to most general.
// - Multi-catch (A | B) groups types that share the same handling.
// - finally always runs - success, caught, or not caught.

public class Ex {
    public static void main(String[] args) {
        String rawAmount = "oops";   // try also: null, "-10", "42.50"

        try {
            double amount = Double.parseDouble(rawAmount);
            if (amount <= 0) {
                throw new IllegalArgumentException("must be positive");
            }
            System.out.println("Authorized " + amount);
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Invalid amount input.");
        } catch (IllegalArgumentException e) {
            System.out.println("Rule violated: " + e.getMessage());
        } finally {
            System.out.println("Audit log written.");
        }
    }
}
