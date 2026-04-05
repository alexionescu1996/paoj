package org.example.streaming.sealed;

import java.util.List;

/**
 * NON-SEALED: oricine poate extinde FamilySubscription.
 * Deschidem ierarhia de la acest punct.
 */
public non-sealed class FamilySubscription extends Subscription {
    private final List<String> members;
    private final double monthlyPrice;

    public FamilySubscription(String username, String startDate,
                              List<String> members, double monthlyPrice) {
        super(username, startDate);
        this.members = members;
        this.monthlyPrice = monthlyPrice;
    }

    public List<String> getMembers() {
        return members;
    }

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    public double pricePerMember() {
        return monthlyPrice / members.size();
    }

    @Override
    public String toString() {
        return super.toString() + " [FAMILY - " + members.size()
                + " membri, " + monthlyPrice + " RON/luna]";
    }
}
