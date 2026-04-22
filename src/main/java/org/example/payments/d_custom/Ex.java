package org.example.payments.d_custom;

// Custom exceptions:
// - extend Exception           -> checked   (compiler forces handling)
// - extend RuntimeException    -> unchecked (no compiler enforcement)
//
// Why write your own? Built-in exceptions are too generic. A domain
// exception (InsufficientFundsException) carries meaning and extra
// fields (e.g. missing amount) that business code can react to.

public class Ex {
    public static void main(String[] args) {

        Wallet wallet = new Wallet("Alice", 100.0);

        try {
            wallet.pay(40.0);
            wallet.pay(80.0);   // will throw InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.out.println("Payment declined. Top up at least " + e.getMissing());
        }

        try {
            wallet.pay(-5.0);   // InvalidCardException (unchecked)
        } catch (InvalidCardException e) {
            System.out.println("Bad request: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            // required because pay() declares it, even though -5.0 won't trigger it
            System.out.println("Unexpected: " + e.getMessage());
        }
    }
}
