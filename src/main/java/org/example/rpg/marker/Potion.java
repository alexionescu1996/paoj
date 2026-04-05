package org.example.rpg.marker;

import org.example.rpg.enums.Rarity;

/**
 * Potion este Tradeable dar NU Enchantable si NU Cloneable.
 * Demonstreaza cum marker interfaces permit verificari selective cu instanceof.
 */
public class Potion extends GameItem implements Tradeable {
    private int healAmount;

    public Potion(String name, Rarity rarity, int healAmount) {
        super(name, rarity);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }

    @Override
    public String toString() {
        return name + " [" + rarity + "] (heal=" + healAmount + ")";
    }
}
