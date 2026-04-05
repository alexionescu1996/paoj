package org.example.rpg.sealed;

/**
 * NON-SEALED: oricine poate extinde TradeEvent.
 * Deschidem ierarhia de la acest punct.
 */
public non-sealed class TradeEvent extends GameEvent {
    private final String buyer;
    private final String seller;
    private final int goldAmount;

    public TradeEvent(String timestamp, String buyer, String seller, int goldAmount) {
        super(timestamp, buyer + " cumpara de la " + seller + " pentru " + goldAmount + " gold");
        this.buyer = buyer;
        this.seller = seller;
        this.goldAmount = goldAmount;
    }

    public String getBuyer() { return buyer; }
    public String getSeller() { return seller; }
    public int getGoldAmount() { return goldAmount; }
}
