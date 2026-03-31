package org.example.hero.extensions;

public class HeroAbility implements Ability {

    private final String name;
    private final int strength;
    private final String element;

    public HeroAbility(String name, int strength, String element) {
        this.name = name;
        this.strength = strength;
        this.element = element;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public String getDescription() {
        return getName() + " (" + element + ") with strength " + getStrength();
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
