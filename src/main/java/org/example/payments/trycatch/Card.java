package org.example.payments.trycatch;

public class Card {
    private final String number;
    private double balance;

    public Card(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    public void charge(double amount) {
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds on card " + masked());
        }
        balance -= amount;
    }

    public String masked() {
        return "****" + number.substring(number.length() - 4);
    }

    public double getBalance() {
        return balance;
    }
}
