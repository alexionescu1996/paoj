package org.example.inheritance;

public class Warrior implements GameCharacter {

    @Override
    public String characterName() {
        return "Warrior";
    }

    @Override
    public double attack(int power) {
        double damage = power * 2.0;
        System.out.println(characterName() + " swings sword for " + damage + " damage!");
        return damage;
    }

    @Override
    public int heal(int amount) {
        System.out.println(characterName() + " uses a health potion! +" + amount + " HP");
        return amount;
    }

    @Override
    public void move(String direction, int steps) {
        System.out.println(characterName() + " charges " + steps + " steps " + direction);
    }
}
