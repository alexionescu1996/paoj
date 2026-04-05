package org.example.rpg.marker;

import org.example.rpg.enums.Rarity;

/**
 * Clasa de baza pentru toate item-urile din joc.
 */
public abstract class GameItem {
    protected String name;
    protected Rarity rarity;

    public GameItem(String name, Rarity rarity) {
        this.name = name;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    @Override
    public String toString() {
        return name + " [" + rarity + "]";
    }
}
