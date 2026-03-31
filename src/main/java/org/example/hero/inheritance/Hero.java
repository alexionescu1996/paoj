package org.example.hero.inheritance;

public class Hero implements SuperPower {

    private final String name;
    private final String powerName;
    private final int powerLevel;
    private final String weakness;
    private final boolean lethal;

    public Hero(String name, String powerName, int powerLevel, String weakness, boolean lethal) {
        this.name = name;
        this.powerName = powerName;
        this.powerLevel = powerLevel;
        this.weakness = weakness;
        this.lethal = lethal;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getPowerName() {
        return powerName;
    }

    @Override
    public int getPowerLevel() {
        return powerLevel;
    }

    @Override
    public String getWeakness() {
        return weakness;
    }

    @Override
    public boolean isLethal() {
        return lethal;
    }

    @Override
    public String toString() {
        return name + " [" + powerName + ", level=" + powerLevel +
                ", weakness=" + weakness + ", lethal=" + lethal + "]";
    }
}
