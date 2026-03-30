package org.example.basics;

/**
 * A superhero has a name and can unleash a power.
 *
 * The modifiers below are redundant — interface fields are implicitly
 * public, static, and final. IntelliJ greys them out to signal this.
 */
public interface SuperPower {

    public static final String HERO_MOTTO = "With great power comes great responsibility";
    public static final int MAX_POWER_LEVEL = 100;

    void activate(String target);

    int powerLevel();
}
