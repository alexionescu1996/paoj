package org.example.basics;

public class BasicDemo {

    public static void run() {
        System.out.println("=== Basics: interface declaration and anonymous class ===");
        System.out.println("Motto: " + SuperPower.HERO_MOTTO);

        SuperPower superPower = new SuperPower() {
            @Override
            public void activate(String target) {
                System.out.println("Laser beam fired at " + target + "! Power: " + powerLevel());
            }

            @Override
            public int powerLevel() {
                return 85;
            }
        };

        superPower.activate("Thanos");
        superPower.activate("Loki");
        System.out.println();
    }
}
