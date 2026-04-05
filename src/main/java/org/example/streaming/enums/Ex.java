package org.example.streaming.enums;

public class Ex {
    public static void main(String[] args) {
        System.out.println("=== ENUM - Genre ===");
        for (Genre g : Genre.values()) {
            System.out.printf("%-12s | %-12s | %s | recomandat: %s%n",
                    g, g.getDisplayName(), g.getDescription(), g.getRecommendation().getDisplayName());
        }

        System.out.println("\nDiscover Weekly: " + Genre.randomGenre().getDisplayName());

        // valueOf - converteste String -> enum
        Genre rock = Genre.valueOf("ROCK");
        System.out.println("valueOf(\"ROCK\"): " + rock.getDisplayName());

        // ordinal - pozitia in enum
        System.out.println("ROCK ordinal: " + Genre.ROCK.ordinal());

        System.out.println("\n=== ENUM - ContentRating ===");
        int userAge = 15;
        System.out.println("Varsta utilizator: " + userAge);
        for (ContentRating rating : ContentRating.values()) {
            String access = rating.isAllowedForAge(userAge) ? "PERMITE" : "BLOCAT";
            System.out.printf("  %-10s (%s): %s%n", rating, rating.getLabel(), access);
        }

        System.out.println("\n=== ENUM - Quality (metoda abstracta per constanta) ===");
        for (Quality q : Quality.values()) {
            System.out.printf("%-10s | %s | 60 min = %.1f MB%n",
                    q, q.formatInfo(), q.dataMB(60));
        }

        // Enum in switch
        System.out.println("\n=== Switch pe enum ===");
        Genre chosen = Genre.JAZZ;
        String mood = switch (chosen) {
            case POP, R_AND_B -> "Energic si distractiv!";
            case ROCK, ELECTRONIC -> "Intens si puternic!";
            case HIP_HOP -> "Ritmic si cool!";
            case JAZZ, CLASSICAL -> "Relaxant si sofisticat!";
            case PODCAST -> "Informativ si captivant!";
        };
        System.out.println(chosen.getDisplayName() + ": " + mood);
    }
}
