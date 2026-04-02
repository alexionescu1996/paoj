package org.example.hero.metahuman.game;

public class GameSimulation {

    public static void main(String[] args) {
        SuperHero superman = new SuperHero("Superman", 999, 500);
        SuperHero batman = new SuperHero("Batman", 850, 400);
        SuperVillain joker = new SuperVillain("Joker", 400, 300);
        SuperVillain thanos = new SuperVillain("Thanos", 950, 550);

        System.out.println("=== BATTLE 1: Superman vs Thanos ===");
        fight(superman, thanos);

        System.out.println();

        System.out.println("=== BATTLE 2: Batman vs Joker ===");
        fight(batman, joker);
    }

    public static void fight(Superpower fighter1, Superpower fighter2) {
        int round = 1;
        while (fighter1.isAlive() && fighter2.isAlive()) {
            System.out.println("-- Round " + round + " --");

            int damage1 = fighter1.attack();
            fighter2.takeDamage(damage1);
            System.out.println(fighter1 + " attacks for " + damage1 + " damage!");
            System.out.println(fighter2 + " takes the hit.");

            if (!fighter2.isAlive()) {
                System.out.println(fighter2 + " is defeated!");
                break;
            }

            int damage2 = fighter2.attack();
            fighter1.takeDamage(damage2);
            System.out.println(fighter2 + " attacks for " + damage2 + " damage!");
            System.out.println(fighter1 + " takes the hit.");

            if (!fighter1.isAlive()) {
                System.out.println(fighter1 + " is defeated!");
                break;
            }

            round++;
        }
    }
}
