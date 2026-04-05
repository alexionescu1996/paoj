package org.example.streaming.sealed;

/**
 * SEALED CLASS (Java 17+):
 *
 * O clasa sealed restrictioneaza CINE o poate extinde.
 * Doar clasele listate in "permits" pot mosteni din ea.
 *
 * De ce?
 *   - Control total asupra ierarhiei de mostenire
 *   - Compilatorul stie TOATE subtipurile -> switch exhaustiv
 *   - Modelam domenii inchise (un abonament e DOAR Free, Premium, sau Family)
 *
 * Clasele permise TREBUIE sa fie: final, sealed, sau non-sealed.
 */
public sealed class Subscription permits FreeSubscription, PremiumSubscription, FamilySubscription {
    private final String username;
    private final String startDate;

    public Subscription(String username, String startDate) {
        this.username = username;
        this.startDate = startDate;
    }

    public String getUsername() {
        return username;
    }

    public String getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return username + " (din " + startDate + ")";
    }
}
