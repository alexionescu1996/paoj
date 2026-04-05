package org.example.rpg.diamond;

public class Ex {
    public static void main(String[] args) {
        System.out.println("=== PROBLEMA ROMBULUI (Diamond Problem) ===\n");

        PureWarrior conan = new PureWarrior("Conan");
        Paladin arthas = new Paladin("Arthas");

        // PureWarrior - un singur prepare(), niciun conflict
        System.out.println("--- PureWarrior (niciun conflict) ---");
        System.out.println(conan.prepare());
        System.out.println(conan.fight());

        // Paladin - CONFLICT rezolvat prin override explicit
        System.out.println("\n--- Paladin (diamond problem rezolvat) ---");
        System.out.println(arthas.prepare());
        System.out.println(arthas.fight()); // din Warrior
        System.out.println(arthas.heal());  // din Healer

        // Polimorfism - Paladin poate fi vazut ca Warrior SAU Healer
        System.out.println("\n--- Polimorfism ---");
        Warrior asWarrior = arthas;
        Healer asHealer = arthas;
        System.out.println("Ca Warrior: " + asWarrior.fight());
        System.out.println("Ca Healer:  " + asHealer.heal());

        // Ambele referinte apeleaza ACELASI prepare() (cel suprascris de Paladin)
        System.out.println("\nPrin ref Warrior: ");
        System.out.println(asWarrior.prepare());
        System.out.println("\nPrin ref Healer (acelasi rezultat!):");
        System.out.println(asHealer.prepare());

        /*
         * REGULI Diamond Problem:
         * 1. Daca doua interfete au aceeasi default method -> clasa TREBUIE sa suprascrie
         * 2. Clasa poate apela oricare varianta cu InterfaceName.super.metoda()
         * 3. Daca doar o interfata are default si cealalta e abstracta -> default-ul castiga
         * 4. Clasa concreta castiga intotdeauna peste default din interfata
         */
    }
}
