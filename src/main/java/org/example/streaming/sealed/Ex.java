package org.example.streaming.sealed;

import java.util.List;

public class Ex {
    public static void main(String[] args) {
        System.out.println("=== SEALED CLASSES + PERMITS ===\n");

        // Cream diferite tipuri de abonamente
        List<Subscription> subscribers = List.of(
                new FreeSubscription("alex_music", "2024-01-15", 6),
                new StudentPremium("maria_uni", "2024-03-01", "Universitatea Bucuresti"),
                new RegularPremium("dan_pro", "2023-11-20"),
                new FamilySubscription("elena_fam", "2024-02-10",
                        List.of("elena", "mihai", "ana", "radu"), 49.99),
                new DuoSubscription("ioana_duo", "2024-05-01", "cristian")
        );

        // Afisam toate abonamentele
        System.out.println("--- Toti abonatii ---");
        subscribers.forEach(System.out::println);

        // SWITCH EXHAUSTIV - compilatorul stie TOATE subtipurile sealed class
        System.out.println("\n--- Switch pe sealed class ---");
        for (Subscription sub : subscribers) {
            String benefit = switch (sub) {
                case FreeSubscription f ->
                        "Gratuit dar cu " + f.getAdsPerHour() + " reclame/ora";
                case StudentPremium s ->
                        "Student la " + s.getUniversity() + " - pret redus " + s.getMonthlyPrice() + " RON";
                case RegularPremium r ->
                        "Premium complet - " + r.getMaxQuality() + " quality, " + r.getMonthlyPrice() + " RON";
                case FamilySubscription f ->
                        "Familie " + f.getMembers().size() + " membri - "
                                + "%.2f RON/persoana".formatted(f.pricePerMember());
                // NOTA: avem nevoie de default deoarece FamilySubscription este non-sealed,
                // deci compilatorul nu poate garanta ca am acoperit toate subtipurile.
                // Daca TOATE clasele permise ar fi final sau sealed, NU am avea nevoie de default.
                default -> "Tip necunoscut de abonament";
            };
            System.out.println("  " + sub.getUsername() + " -> " + benefit);
        }

        /*
         * IERARHIA:
         *
         * Subscription (sealed)
         *   ├── FreeSubscription (final) - nimeni nu mai extinde
         *   ├── PremiumSubscription (sealed) - doar StudentPremium si RegularPremium
         *   │     ├── StudentPremium (final)
         *   │     └── RegularPremium (final)
         *   └── FamilySubscription (non-sealed) - oricine poate extinde
         *         └── DuoSubscription (clasa normala)
         *
         * Regulile sealed:
         * 1. Clasele permise trebuie sa fie: final, sealed, sau non-sealed
         * 2. Clasele permise trebuie sa fie in acelasi pachet (sau modul)
         * 3. Compilatorul stie toate subtipurile -> switch exhaustiv fara default
         * 4. non-sealed "deschide" ierarhia pentru extensii noi
         */
    }
}
