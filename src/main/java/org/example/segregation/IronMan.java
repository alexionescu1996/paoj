package org.example.segregation;

public class IronMan implements Flyable, Shootable {

    @Override
    public void fly(int altitudeMeters) {
        System.out.println("Iron Man rockets to " + altitudeMeters + "m!");
    }

    @Override
    public double shoot(int accuracyPercent) {
        double damage = accuracyPercent * 1.5;
        System.out.println("Repulsor blast! Accuracy: " + accuracyPercent + "% → Damage: " + damage);
        return damage;
    }
}
