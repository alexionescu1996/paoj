package org.example.functional;

public class FunctionalDemo {

    public static void run() {
        System.out.println("=== Functional: @FunctionalInterface, lambdas, method references ===");

        // Lambda — concise way to implement a single-method interface
        PowerActivator blast = (power, armor) -> power * 1.0 - armor * 0.5;
        System.out.println("Repulsor blast damage: " + blast.activate(90, 30));

        // Another lambda — different power
        PowerActivator lightning = (power, armor) -> Math.pow(power, 1.2) - armor;
        System.out.println("Lightning strike damage: " + lightning.activate(70, 20));

        // HealingFactor via lambda
        HealingFactor wolverine = (base, bonus) -> base + bonus * 2.5;
        System.out.println("Wolverine heals to: " + wolverine.heal(50, 20));

        // Method reference — even shorter
        HealingFactor hyperbaricHeal = Math::max;
        System.out.println("Hyperbaric heal result: " + hyperbaricHeal.heal(60, 80));

        // Superhero has 3 abstract methods — cannot use a lambda, needs anonymous class
        Superhero thor = new Superhero() {
            @Override
            public String heroName() { return "Thor"; }

            @Override
            public double activate(int powerLevel, int targetArmor) {
                return Math.pow(powerLevel, 1.5) - targetArmor;
            }

            @Override
            public double heal(int baseHealth, int bonus) {
                return baseHealth + bonus;
            }
        };

        System.out.println(thor.heroName() + " strikes for: " + thor.activate(100, 10));
        System.out.println(thor.heroName() + " heals to: " + thor.heal(30, 70));
        System.out.println();
    }
}
