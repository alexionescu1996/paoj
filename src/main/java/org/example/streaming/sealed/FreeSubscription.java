package org.example.streaming.sealed;

/**
 * FINAL: nimeni nu mai poate extinde FreeSubscription.
 * Aceasta este o "frunza" in ierarhie.
 */
public final class FreeSubscription extends Subscription {
    private final int adsPerHour;

    public FreeSubscription(String username, String startDate, int adsPerHour) {
        super(username, startDate);
        this.adsPerHour = adsPerHour;
    }

    public int getAdsPerHour() {
        return adsPerHour;
    }

    @Override
    public String toString() {
        return super.toString() + " [FREE - " + adsPerHour + " reclame/ora]";
    }
}
