package org.example.basics;

/**
 * Every game character has a name, a level, and can attack.
 *
 * The modifiers below are redundant — interface fields are implicitly
 * public, static, and final. IntelliJ greys them out to signal this.
 */
public interface Character {

    public static final int MAX_LEVEL = 100;
    public static final String DEFAULT_SPAWN = "Town Square";

    void attack(String target);

    int level();
}
