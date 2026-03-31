package org.example.hero.extensions;

public interface Ability {

    String getName();

    int getStrength();

    default String getDescription() {
        return getName() + " with strength " + getStrength();
    }

    default boolean isOverpowered() {
        return getStrength() > 900;
    }

    static Ability create(String name, int strength) {
        return new Ability() {
            @Override
            public String getName() {
                return name;
            }

            @Override
            public int getStrength() {
                return strength;
            }
        };
    }

    static int compare(Ability a, Ability b) {
        return Integer.compare(a.getStrength(), b.getStrength());
    }
}
