package org.example.hero.metahuman;

public class Hero implements MetaHuman, Side {

    private final String name;
    private final int powerLevel;

    public Hero(String name, int powerLevel) {
        this.name = name;
        this.powerLevel = powerLevel;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPowerLevel() {
        return powerLevel;
    }

    public String getSide() {
        return GOOD;
    }

    @Override
    public String toString() {
        return name + " (power=" + powerLevel + ", side=" + getSide() + ")";
    }
}
