package org.example.rpg.defaults;

/**
 * Archer implementeaza Combatant dar NU suprascrie attack().
 * Va folosi default method-ul din Combatant.
 */
public class Archer implements Combatant {
    private String name;
    private int attackPower;
    private int health;

    public Archer(String name, int attackPower, int health) {
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

    // NU suprascriem attack() -> se foloseste default-ul din Combatant
}
