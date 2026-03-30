package org.example.segregation;

public class Cleric implements Healable, Movable {

    @Override
    public int heal(int amount) {
        int healed = amount * 2;
        System.out.println("Cleric channels holy light! Healed: " + healed + " HP");
        return healed;
    }

    @Override
    public void move(String direction, int steps) {
        System.out.println("Cleric walks " + steps + " steps " + direction);
    }
}
