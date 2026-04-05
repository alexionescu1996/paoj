package org.example.streaming.sealed;

import java.util.List;

public class Ex {
    public static void main(String[] args) {
        List<Subscription> subs = List.of(
                new FreeSub("alex"),
                new PremiumSub("maria", 29.99),
                new FamilySub("elena", 4)
        );

        subs.forEach(System.out::println);

        // Switch pe sealed class
        System.out.println("\n--- Switch ---");
        for (Subscription sub : subs) {
            String info = switch (sub) {
                case FreeSub f -> f.getUsername() + " asculta cu reclame";
                case PremiumSub p -> p.getUsername() + " plateste " + p.getPrice() + " RON";
                case FamilySub f -> f.getUsername() + " imparte cu " + f.getMembers() + " membri";
                default -> "necunoscut";
            };
            System.out.println(info);
        }

        /*
         * Subscription (sealed)
         *   ├── FreeSub (final)
         *   ├── PremiumSub (final)
         *   └── FamilySub (non-sealed) - poate fi extinsa
         */
    }
}
