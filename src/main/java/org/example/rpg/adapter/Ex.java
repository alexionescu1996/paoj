package org.example.rpg.adapter;

import java.util.List;

public class Ex {
    public static void main(String[] args) {
        System.out.println("=== ADAPTER PATTERN ===\n");

        // Sistem VECHI - nu respecta interfata noua
        LegacyCombatSystem oldUnit = new LegacyCombatSystem("Goblin Veteran", 60, 100);
        System.out.println("--- Sistem legacy (metode vechi) ---");
        System.out.println("Unit: " + oldUnit.getUnitName());
        System.out.println("Str: " + oldUnit.getStr());
        System.out.println("Strike damage: " + oldUnit.strike());

        // Sistem NOU
        ModernWarrior modernUnit = new ModernWarrior("Dragon Knight", 75, 120);

        // ADAPTER: impachetam unitatea veche in adapter
        ModernCombatant adaptedUnit = new LegacyAdapter(oldUnit);

        // Acum ambele respecta ACEEASI interfata!
        System.out.println("\n--- Ambele unitati prin interfata moderna ---");
        List<ModernCombatant> combatants = List.of(modernUnit, adaptedUnit);

        for (ModernCombatant c : combatants) {
            System.out.printf("%-20s | ATK: %3d | HP: %3d%n",
                    c.getName(), c.getAttackPower(), c.getHealth());
        }

        // Pot lupta intre ele prin aceeasi interfata!
        System.out.println("\n--- Lupta ---");
        System.out.println(modernUnit.attack(adaptedUnit));
        System.out.println(adaptedUnit.attack(modernUnit));

        /*
         * AVANTAJELE Adapter Pattern:
         * 1. Nu modificam codul vechi (LegacyCombatSystem ramane intact)
         * 2. Codul nou nu stie ca lucreaza cu un sistem vechi
         * 3. Putem integra oricand sisteme externe/legacy
         * 4. Respectam Open/Closed Principle (open for extension, closed for modification)
         */
    }
}
