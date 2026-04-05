package org.example.rpg.sealed;

/**
 * SEALED: QuestEvent este si ea sealed - permite doar subtipurile specificate.
 * Cream o sub-ierarhie controlata.
 */
public sealed class QuestEvent extends GameEvent permits QuestStartEvent, QuestCompleteEvent {
    private final String questName;

    public QuestEvent(String timestamp, String description, String questName) {
        super(timestamp, description);
        this.questName = questName;
    }

    public String getQuestName() {
        return questName;
    }
}
