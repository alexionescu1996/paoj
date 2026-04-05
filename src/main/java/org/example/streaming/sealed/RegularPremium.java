package org.example.streaming.sealed;

import org.example.streaming.enums.Quality;

public final class RegularPremium extends PremiumSubscription {
    public RegularPremium(String username, String startDate) {
        super(username, startDate, 29.99, Quality.LOSSLESS);
    }

    @Override
    public String toString() {
        return super.getUsername() + " (din " + super.getStartDate()
                + ") [PREMIUM - 29.99 RON/luna, LOSSLESS]";
    }
}
