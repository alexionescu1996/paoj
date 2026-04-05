package org.example.streaming.sealed;

/**
 * SEALED CLASS - doar clasele din "permits" pot extinde.
 * Clasele permise trebuie sa fie: final, sealed, sau non-sealed.
 */
public sealed class Subscription permits FreeSub, PremiumSub, FamilySub {
    private final String username;

    public Subscription(String username) {
        this.username = username;
    }

    public String getUsername() { return username; }
}
