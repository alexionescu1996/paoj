package org.example.rpg.marker;

import org.example.rpg.enums.Rarity;

/**
 * QuestItem NU implementeaza nici Tradeable, nici Enchantable, nici Cloneable.
 * Este un item unic de quest - nu poate fi vandut, enchanted, sau duplicat.
 */
public class QuestItem extends GameItem {
    private String questName;

    public QuestItem(String name, Rarity rarity, String questName) {
        super(name, rarity);
        this.questName = questName;
    }

    @Override
    public String toString() {
        return name + " [" + rarity + "] (quest: " + questName + ")";
    }
}
