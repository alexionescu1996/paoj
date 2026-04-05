package org.example.rpg.diamond;

/**
 * Interfata Warrior - are o default method prepare().
 */
public interface Warrior {

    String getName();

    default String prepare() {
        return getName() + " isi ascute spada si isi pune armura.";
    }

    default String fight() {
        return getName() + " lupta cu spada!";
    }
}
