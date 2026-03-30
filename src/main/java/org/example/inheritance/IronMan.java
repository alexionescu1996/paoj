package org.example.inheritance;

public class IronMan implements Superhero {

    @Override
    public String heroName() {
        return "Iron Man";
    }

    @Override
    public void fly(int altitudeMeters) {
        System.out.println(heroName() + " rockets to " + altitudeMeters + "m!");
    }

    @Override
    public double shoot(int accuracyPercent) {
        double damage = accuracyPercent * 1.5;
        System.out.println(heroName() + " fires repulsor! Accuracy: " + accuracyPercent + "% → Damage: " + damage);
        return damage;
    }
}
