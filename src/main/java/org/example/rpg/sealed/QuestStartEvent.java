package org.example.rpg.sealed;

public final class QuestStartEvent extends QuestEvent {
    private final int difficulty;

    public QuestStartEvent(String timestamp, String questName, int difficulty) {
        super(timestamp, "Quest inceput: " + questName + " (dificultate: " + difficulty + ")", questName);
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
