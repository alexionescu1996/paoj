package org.example.streaming.sealed;

import java.util.List;

/**
 * Poate extinde FamilySubscription deoarece FamilySubscription este NON-SEALED.
 * Daca FamilySubscription ar fi fost final sau sealed, aceasta clasa nu ar compila.
 */
public class DuoSubscription extends FamilySubscription {

    public DuoSubscription(String username, String startDate, String partner) {
        super(username, startDate, List.of(username, partner), 39.99);
    }

    @Override
    public String toString() {
        return getUsername() + " (din " + getStartDate()
                + ") [DUO - 2 membri, 39.99 RON/luna]";
    }
}
