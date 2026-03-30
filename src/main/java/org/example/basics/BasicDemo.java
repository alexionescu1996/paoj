package org.example.basics;

public class BasicDemo {

    public static void run() {
        System.out.println("=== Basics: interface declaration and anonymous class ===");
        System.out.println("Max level: " + Character.MAX_LEVEL);
        System.out.println("Spawn point: " + Character.DEFAULT_SPAWN);

        Character rogue = new Character() {
            @Override
            public void attack(String target) {
                System.out.println("Rogue backstabs " + target + " for " + (level() * 4) + " damage!");
            }

            @Override
            public int level() {
                return 12;
            }
        };

        rogue.attack("Goblin");
        rogue.attack("Cave Troll");
        System.out.println();
    }
}
