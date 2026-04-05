package org.example.streaming.sealed;

import org.example.streaming.enums.Quality;

/**
 * SEALED: PremiumSubscription este si ea sealed - permite doar subtipurile specificate.
 * Cream o sub-ierarhie controlata.
 */
public sealed class PremiumSubscription extends Subscription
        permits StudentPremium, RegularPremium {
    private final double monthlyPrice;
    private final Quality maxQuality;

    public PremiumSubscription(String username, String startDate,
                               double monthlyPrice, Quality maxQuality) {
        super(username, startDate);
        this.monthlyPrice = monthlyPrice;
        this.maxQuality = maxQuality;
    }

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    public Quality getMaxQuality() {
        return maxQuality;
    }

    @Override
    public String toString() {
        return super.toString() + " [PREMIUM - " + monthlyPrice + " RON/luna, " + maxQuality + "]";
    }
}
