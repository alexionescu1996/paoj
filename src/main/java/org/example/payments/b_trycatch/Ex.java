package org.example.payments.b_trycatch;

// try-catch: handle the exception instead of letting the program crash.
// The program keeps running after the catch block.

public class Ex {
    public static void main(String[] args) {
        String userInput = "12.5o";

        try {
            double amount = Double.parseDouble(userInput);
            System.out.println("Amount: " + amount);
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount: " + userInput);
        }

        System.out.println("Program continues.");
    }
}
