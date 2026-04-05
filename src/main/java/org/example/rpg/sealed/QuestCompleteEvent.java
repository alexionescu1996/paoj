package org.example.rpg.sealed;

public final class QuestCompleteEvent extends QuestEvent {
    private final int xpReward;

    public QuestCompleteEvent(String timestamp, String questName, int xpReward) {
        super(timestamp, "Quest completat: " + questName + " (+%d XP)".formatted(xpReward), questName);
        this.xpReward = xpReward;
    }

    public int getXpReward() {
        return xpReward;
    }
}
