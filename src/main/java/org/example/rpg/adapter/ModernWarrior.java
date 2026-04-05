package org.example.rpg.adapter;

/**
 * Implementare moderna directa a ModernCombatant - nu are nevoie de adapter.
 */
public class ModernWarrior implements ModernCombatant {
    private String name;
    private int attackPower;
    private int health;

    public ModernWarrior(String name, int attackPower, int health) {
        this.name = name;
        this.attackPower = attackPower;
        this.health = health;
    }

    @Override
    public String getName() { return name; }

    @Override
    public int getAttackPower() { return attackPower; }

    @Override
    public int getHealth() { return health; }

    @Override
    public String attack(ModernCombatant target) {
        return name + " ataca pe " + target.getName() + " cu " + attackPower + " damage!";
    }
}
