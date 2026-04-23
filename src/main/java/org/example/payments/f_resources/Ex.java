package org.example.payments.f_resources;

// try-with-resources: any AutoCloseable declared in (...) is closed
// automatically at the end of the try block - even if it throws.
// No more manual finally { session.close(); }.

public class Ex {
    public static void main(String[] args) {
        try (PaymentSession session = new PaymentSession()) {
            session.charge(25.00);
        }   // session.close() called here automatically
    }
}
