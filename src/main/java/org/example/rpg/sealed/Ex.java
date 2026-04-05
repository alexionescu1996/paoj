package org.example.rpg.sealed;

import java.util.List;

public class Ex {
    public static void main(String[] args) {
        System.out.println("=== SEALED CLASSES + PERMITS ===\n");

        // Cream diferite evenimente
        List<GameEvent> eventLog = List.of(
                new QuestStartEvent("10:00", "Dragon's Lair", 5),
                new CombatEvent("10:15", "Hero", "Dragon", 250),
                new CombatEvent("10:16", "Dragon", "Hero", 180),
                new QuestCompleteEvent("10:30", "Dragon's Lair", 500),
                new TradeEvent("10:45", "Hero", "Merchant", 100),
                new BlackMarketTradeEvent("11:00", "Hero", "Shady Dealer", 50)
        );

        // Afisam toate evenimentele
        System.out.println("--- Event Log ---");
        eventLog.forEach(System.out::println);

        // SWITCH EXHAUSTIV - compilatorul stie TOATE subtipurile sealed class
        System.out.println("\n--- Switch exhaustiv pe sealed class ---");
        for (GameEvent event : eventLog) {
            String category = switch (event) {
                case CombatEvent c -> "COMBAT: " + c.getAttacker() + " vs " + c.getDefender();
                case QuestStartEvent q -> "QUEST START: " + q.getQuestName() + " (diff=" + q.getDifficulty() + ")";
                case QuestCompleteEvent q -> "QUEST DONE: " + q.getQuestName() + " (+" + q.getXpReward() + " XP)";
                case TradeEvent t -> "TRADE: " + t.getBuyer() + " <-> " + t.getSeller() + " (" + t.getGoldAmount() + "g)";
                // NOTA: avem nevoie de default deoarece TradeEvent este non-sealed,
                // deci compilatorul nu poate garanta ca am acoperit toate subtipurile.
                // Daca TOATE clasele permise ar fi final sau sealed, NU am avea nevoie de default.
                default -> "UNKNOWN EVENT";
            };
            System.out.println("  " + category);
        }

        /*
         * IERARHIA:
         *
         * GameEvent (sealed)
         *   ├── CombatEvent (final) - nimeni nu mai extinde
         *   ├── QuestEvent (sealed) - doar QuestStartEvent si QuestCompleteEvent
         *   │     ├── QuestStartEvent (final)
         *   │     └── QuestCompleteEvent (final)
         *   └── TradeEvent (non-sealed) - oricine poate extinde
         *         └── BlackMarketTradeEvent (clasa normala)
         *
         * Regulile sealed:
         * 1. Clasele permise trebuie sa fie: final, sealed, sau non-sealed
         * 2. Clasele permise trebuie sa fie in acelasi pachet (sau modul)
         * 3. Compilatorul stie toate subtipurile -> switch exhaustiv fara default
         * 4. non-sealed "deschide" ierarhia pentru extensii noi
         */
    }
}
