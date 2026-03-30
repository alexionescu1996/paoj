package org.example.segregation;

public class Paladin implements Attackable, Healable, Movable {

    @Override
    public double attack(int power) {
        double damage = power * 1.3;
        System.out.println("Paladin smites for " + damage + " holy damage!");
        return damage;
    }

    @Override
    public int heal(int amount) {
        int healed = (int) (amount * 1.5);
        System.out.println("Paladin lays on hands! Healed: " + healed + " HP");
        return healed;
    }

    @Override
    public void move(String direction, int steps) {
        System.out.println("Paladin marches " + steps + " steps " + direction);
    }
}
