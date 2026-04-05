package org.example.rpg.enums;

/**
 * Enum cu campuri, constructor, metode.
 * Fiecare element are un damage multiplier si o culoare asociata.
 */
public enum Element {
    FIRE("Rosu", 1.5),
    WATER("Albastru", 1.2),
    EARTH("Verde", 1.0),
    AIR("Alb", 1.3),
    LIGHTNING("Galben", 1.8);

    private final String color;
    private final double damageMultiplier;

    Element(String color, double damageMultiplier) {
        this.color = color;
        this.damageMultiplier = damageMultiplier;
    }

    public String getColor() {
        return color;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    /**
     * Metoda care returneaza elementul opus (weakness).
     */
    public Element getWeakness() {
        return switch (this) {
            case FIRE -> WATER;
            case WATER -> LIGHTNING;
            case EARTH -> AIR;
            case AIR -> EARTH;
            case LIGHTNING -> FIRE;
        };
    }

    /**
     * Metoda statica: genereaza un element random.
     */
    public static Element randomElement() {
        Element[] elements = values();
        int index = (int) (Math.random() * elements.length);
        return elements[index];
    }
}
