package org.example.rpg.enums;

/**
 * Enum care implementeaza o interfata.
 * Fiecare raritate are un pret de baza si un numar maxim de enchantments.
 */
public enum Rarity implements Comparable<Rarity> {
    COMMON(10, 1),
    UNCOMMON(25, 2),
    RARE(100, 3),
    EPIC(500, 4),
    LEGENDARY(2000, 5);

    private final int basePrice;
    private final int maxEnchantments;

    Rarity(int basePrice, int maxEnchantments) {
        this.basePrice = basePrice;
        this.maxEnchantments = maxEnchantments;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getMaxEnchantments() {
        return maxEnchantments;
    }

    /**
     * Verifica daca raritatea curenta este cel putin la nivelul dat.
     */
    public boolean isAtLeast(Rarity other) {
        return this.ordinal() >= other.ordinal();
    }
}
