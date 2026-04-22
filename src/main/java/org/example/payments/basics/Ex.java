package org.example.payments.basics;

// Compile-time errors vs runtime errors (exceptions).
//
// Compile-time error: the code does not compile. The compiler refuses
// to produce bytecode. Example (uncomment to see):
//
//     double amount = "99.90";            // incompatible types
//     processPayment(;                    // syntax error
//     unknownMethod();                    // cannot resolve symbol
//
// Runtime error: the code compiles, but fails while running.
// These are represented as exceptions (objects extending Throwable).

public class Ex {
    public static void main(String[] args) {

        // 1. NumberFormatException - parsing a bad amount from a form field
        String userInput = "12.5o";
        try {
            double amount = Double.parseDouble(userInput);
            System.out.println("Parsed amount: " + amount);
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format: " + userInput);
        }

        // 2. ArithmeticException - splitting a bill between 0 people
        int total = 100;
        int people = 0;
        try {
            int perPerson = total / people;
            System.out.println("Each pays: " + perPerson);
        } catch (ArithmeticException e) {
            System.out.println("Cannot split bill: " + e.getMessage());
        }

        // 3. NullPointerException - using a card reference that was never set
        String cardNumber = null;
        try {
            int length = cardNumber.length();
            System.out.println("Card length: " + length);
        } catch (NullPointerException e) {
            System.out.println("No card provided.");
        }

        // 4. ArrayIndexOutOfBoundsException - reading past the end of a batch
        double[] batch = {19.99, 5.50, 42.00};
        try {
            System.out.println("4th payment: " + batch[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No 4th payment in this batch.");
        }
    }
}
