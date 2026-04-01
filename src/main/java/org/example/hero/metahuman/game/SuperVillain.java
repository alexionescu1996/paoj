package org.example.hero.metahuman.game;

import org.example.hero.metahuman.Villain;

public class SuperVillain extends Villain implements Superpower {

    private int health;

    public SuperVillain(String name, int powerLevel, int health) {
        super(name, powerLevel);
        this.health = health;
    }

    @Override
    public int attack() {
        return getPowerLevel() / 10 + (int) (Math.random() * 20);
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return getName() + " [VILLAIN] (power=" + getPowerLevel() + ", health=" + health + ")";
    }
}
