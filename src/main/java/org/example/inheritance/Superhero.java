package org.example.inheritance;

/**
 * A full superhero combines flight, ranged attack, and has an identity.
 * An interface can extend multiple interfaces.
 */
public interface Superhero extends Flyable, Shootable {
    String heroName();
}
