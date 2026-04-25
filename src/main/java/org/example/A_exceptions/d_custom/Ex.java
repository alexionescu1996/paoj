package org.example.A_exceptions.d_custom;

// Define a domain-specific exception (InsufficientFundsException) and
// throw it from business code. Built-in exceptions are too generic -
// a custom type gives the error a clear meaning.

public class Ex {
    public static void main(String[] args) {
        try {
            pay(100, 40);
        } catch (InsufficientFundsException e) {
            System.out.println("Declined: " + e.getMessage());
        }
    }

    static void pay(double amount, double balance) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("need " + (amount - balance) + " more");
        }
        System.out.println("Paid " + amount);
    }
}
