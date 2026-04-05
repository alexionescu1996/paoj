package org.example.rpg.adapter;

/**
 * Interfata moderna pe care o foloseste restul aplicatiei.
 */
public interface ModernCombatant {
    String getName();
    int getAttackPower();
    int getHealth();

    String attack(ModernCombatant target);
}
