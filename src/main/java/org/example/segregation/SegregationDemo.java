package org.example.segregation;

/**
 * Interface Segregation: a hero implements only the powers it actually has.
 * Falcon can fly but not shoot. Iron Man can do both.
 */
public class SegregationDemo {

    public static void run() {
        System.out.println("=== Segregation: heroes implement only their powers ===");

        Falcon falcon = new Falcon();
        falcon.fly(3000);

        IronMan ironMan = new IronMan();
        ironMan.fly(10000);
        ironMan.shoot(95);
        System.out.println();
    }
}
