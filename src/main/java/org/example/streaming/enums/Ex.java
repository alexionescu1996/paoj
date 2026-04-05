package org.example.streaming.enums;

public class Ex {
    public static void main(String[] args) {
        // Enum simplu
        Genre g = Genre.POP;
        System.out.println("Gen: " + g);
        System.out.println("ordinal: " + g.ordinal());
        System.out.println("valueOf: " + Genre.valueOf("ROCK"));

        // Enum cu campuri
        System.out.println("\n--- Quality ---");
        for (Quality q : Quality.values()) {
            System.out.println(q + " = " + q.getBitrateKbps() + " kbps");
        }

        // Enum cu metoda abstracta
        System.out.println("\n--- UserRole ---");
        for (UserRole role : UserRole.values()) {
            System.out.println(role + " -> " + role.monthlyPrice() + " RON/luna");
        }

        // Switch pe enum
        Quality chosen = Quality.HIGH;
        String desc = switch (chosen) {
            case LOW -> "Economie de date";
            case NORMAL -> "Calitate standard";
            case HIGH -> "Calitate inalta";
            case LOSSLESS -> "Fara pierderi";
        };
        System.out.println("\n" + chosen + ": " + desc);
    }
}
