package org.example.segregation;

public class Archer implements Attackable, Movable {

    @Override
    public double attack(int power) {
        double damage = power * 1.8;
        System.out.println("Archer fires an arrow! Damage: " + damage);
        return damage;
    }

    @Override
    public void move(String direction, int steps) {
        System.out.println("Archer rolls " + steps + " steps " + direction);
    }
}
