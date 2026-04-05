package org.example.rpg.sealed;

/**
 * Poate extinde TradeEvent deoarece TradeEvent este NON-SEALED.
 * Daca TradeEvent ar fi fost final sau sealed, aceasta clasa nu ar compila.
 */
public class BlackMarketTradeEvent extends TradeEvent {
    private final boolean isIllegal;

    public BlackMarketTradeEvent(String timestamp, String buyer, String seller, int goldAmount) {
        super(timestamp, buyer, seller, goldAmount);
        this.isIllegal = true;
    }

    @Override
    public String toString() {
        return super.toString() + " [BLACK MARKET - ILLEGAL]";
    }
}
