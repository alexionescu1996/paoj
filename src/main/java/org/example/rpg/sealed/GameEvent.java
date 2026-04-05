package org.example.rpg.sealed;

/**
 * SEALED CLASS (Java 17+):
 *
 * O clasa sealed restrictioneaza CINE o poate extinde.
 * Doar clasele listate in "permits" pot mosteni din ea.
 *
 * De ce?
 *   - Control total asupra ierarhiei de mostenire
 *   - Compilatorul stie TOATE subtipurile -> switch exhaustiv
 *   - Modelam domenii inchise (un eveniment e DOAR combat, quest, sau trade)
 *
 * Clasele permise TREBUIE sa fie: final, sealed, sau non-sealed.
 */
public sealed class GameEvent permits CombatEvent, QuestEvent, TradeEvent {
    private final String timestamp;
    private final String description;

    public GameEvent(String timestamp, String description) {
        this.timestamp = timestamp;
        this.description = description;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + description;
    }
}
