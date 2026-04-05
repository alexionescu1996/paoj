package org.example.streaming.sealed;

// FINAL - nimeni nu mai extinde
public final class PremiumSub extends Subscription {
    private final double price;

    public PremiumSub(String username, double price) {
        super(username);
        this.price = price;
    }

    public double getPrice() { return price; }

    @Override
    public String toString() {
        return getUsername() + " [PREMIUM " + price + " RON]";
    }
}
