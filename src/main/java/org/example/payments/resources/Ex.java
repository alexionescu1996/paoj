package org.example.payments.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

// try-with-resources:
//
//     try (Resource r = ...) { ... }
//
// Any resource declared in the parentheses is closed automatically
// at the end of the try block. The resource must implement AutoCloseable.
//
// Benefits vs. manual try/finally:
//   - no forgotten close()
//   - close() is called even when the try block throws
//   - multiple resources are closed in reverse order of declaration

public class Ex {
    public static void main(String[] args) {

        // 1. Our own AutoCloseable - a simulated payment gateway session.
        try (PaymentSession session = new PaymentSession("Stripe")) {
            session.charge("card-1", 25.00);
            session.charge("card-2", 9.99);
        }   // session.close() is called here, automatically

        System.out.println("---");

        // 2. Standard library resource (BufferedReader) reading a CSV of payments.
        String csv = "card-1,25.00\ncard-2,9.99\ncard-3,100.00";
        try (BufferedReader reader = new BufferedReader(new StringReader(csv))) {
            String line;
            double total = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                total += Double.parseDouble(parts[1]);
            }
            System.out.println("Total processed: " + total);
        } catch (IOException e) {
            System.out.println("Could not read payments: " + e.getMessage());
        }
    }
}
