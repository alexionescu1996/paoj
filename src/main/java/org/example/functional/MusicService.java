package org.example.functional;

/**
 * Extends two functional interfaces and adds its own method.
 * Has 3 abstract methods total — NOT a functional interface.
 * Cannot be replaced with a lambda; needs an anonymous class or a full implementation.
 */
public interface MusicService extends Playable, Filterable {
    String recommend(String mood);
}
