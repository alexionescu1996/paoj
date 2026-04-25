package org.example.A_exceptions.a_basics;

// Compile-time error: the code does not compile. No .class is produced.
// Runtime error (exception): the code compiles, but fails while running.
//
// This program compiles fine, but crashes with NumberFormatException
// because "12.5o" is not a valid number. Run it and watch the stack trace.

public class Ex {
    public static void main(String[] args) {
        String userInput = "12.5o";
        double amount = Double.parseDouble(userInput);
        System.out.println("Amount: " + amount);
    }
}
