package org.example.inheritance;

/**
 * A full game character combines all combat abilities and has an identity.
 * An interface can extend multiple interfaces — the implementor satisfies all of them.
 */
public interface GameCharacter extends Attackable, Healable, Movable {
    String characterName();
}
