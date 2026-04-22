package org.example.payments.custom;

public class Wallet {
    private final String owner;
    private double balance;

    public Wallet(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void pay(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            // unchecked - violates a precondition
            throw new InvalidCardException("Amount must be positive, got " + amount);
        }
        if (amount > balance) {
            // checked - expected business case, caller must handle
            throw new InsufficientFundsException(amount - balance);
        }
        balance -= amount;
        System.out.println(owner + " paid " + amount + ". Balance: " + balance);
    }
}
