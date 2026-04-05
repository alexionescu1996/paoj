package org.example.rpg.defaults;

/**
 * Knight implementeaza Combatant si Loggable.
 * Foloseste default methods din ambele + suprascrie attack().
 */
public class Knight implements Combatant, Loggable {
    private String name;
    private int attackPower;
    private int health;

    public Knight(String name, int attackPower, int health) {
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

    /**
     * Suprascriem default method-ul attack() cu comportament custom.
     */
    @Override
    public String attack(Combatant target) {
        // Apelam log din Loggable (default method)
        log("se pregateste de atac!");
        // Knight-ul are un atac special
        int damage = calculateDamage(target) + 10; // bonus cavaleresc
        return getName() + " loveste cu spada pe " + target.getName()
                + " cu " + damage + " damage! (bonus cavaleresc +10)";
    }
}
