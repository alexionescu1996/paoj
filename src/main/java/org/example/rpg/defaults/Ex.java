package org.example.rpg.defaults;

public class Ex {
    public static void main(String[] args) {
        System.out.println("=== Default Methods & Static Methods in Interfaces ===\n");

        Knight knight = new Knight("Sir Lancelot", 80, 150);
        Archer archer = new Archer("Legolas", 70, 90);

        // Knight suprascrie attack() -> comportament custom
        System.out.println("--- Knight (override attack) ---");
        System.out.println(knight.attack(archer));

        // Archer NU suprascrie attack() -> foloseste default
        System.out.println("\n--- Archer (default attack) ---");
        System.out.println(archer.attack(knight));

        // Default method: canDefeat
        System.out.println("\n--- Default method: canDefeat ---");
        System.out.println(knight.getName() + " can defeat " + archer.getName() + "? "
                + knight.canDefeat(archer));

        // Static method pe interfata
        System.out.println("\n--- Static method: Combatant.stronger() ---");
        Combatant stronger = Combatant.stronger(knight, archer);
        System.out.println("Mai puternic: " + stronger.getName());

        // Static factory method
        System.out.println("\n--- Static factory: Combatant.createDummy() ---");
        Combatant dummy = Combatant.createDummy("Training Dummy", 0, 999);
        System.out.println(knight.attack(dummy));

        // Loggable default method
        System.out.println("\n--- Loggable default method ---");
        knight.log("A castigat lupta!");

        // Loggable static method
        Loggable.logSystem("Runda de lupta terminata.");

        // IMPORTANT: static methods nu se mostenesc!
        // knight.stronger(...)  // NU COMPILEAZA
        // Trebuie: Combatant.stronger(...)
    }
}
