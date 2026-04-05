package org.example.rpg.enums;

public class Ex {
    public static void main(String[] args) {
        System.out.println("=== ENUM - Element ===");
        for (Element e : Element.values()) {
            System.out.printf("%-10s | culoare: %-10s | multiplier: %.1f | weakness: %s%n",
                    e, e.getColor(), e.getDamageMultiplier(), e.getWeakness());
        }

        System.out.println("\nElement random: " + Element.randomElement());

        // valueOf - converteste String -> enum
        Element fire = Element.valueOf("FIRE");
        System.out.println("valueOf(\"FIRE\"): " + fire);

        // ordinal - pozitia in enum
        System.out.println("FIRE ordinal: " + Element.FIRE.ordinal());

        System.out.println("\n=== ENUM - Rarity ===");
        Rarity epic = Rarity.EPIC;
        System.out.println(epic + " basePrice=" + epic.getBasePrice()
                + " maxEnchantments=" + epic.getMaxEnchantments());
        System.out.println("EPIC isAtLeast RARE? " + epic.isAtLeast(Rarity.RARE));
        System.out.println("COMMON isAtLeast EPIC? " + Rarity.COMMON.isAtLeast(Rarity.EPIC));

        System.out.println("\n=== ENUM - CharacterClass (metoda abstracta per constanta) ===");
        for (CharacterClass cc : CharacterClass.values()) {
            System.out.printf("%-8s | HP: %3d | cry: \"%s\"%n",
                    cc, cc.baseHealth(), cc.battleCry());
        }

        // Enum in switch
        System.out.println("\n=== Switch pe enum ===");
        Element chosen = Element.LIGHTNING;
        String description = switch (chosen) {
            case FIRE -> "Foc arzator!";
            case WATER -> "Apa limpede!";
            case EARTH -> "Pamant solid!";
            case AIR -> "Vant puternic!";
            case LIGHTNING -> "Fulger devastator!";
        };
        System.out.println(chosen + ": " + description);
    }
}
