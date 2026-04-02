package org.example.hero.metahuman.game;

public interface Superpower {
    int attack();
    void takeDamage(int damage);
    int getHealth();
    boolean isAlive();
}
