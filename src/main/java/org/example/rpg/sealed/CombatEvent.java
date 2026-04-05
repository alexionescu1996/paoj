package org.example.rpg.sealed;

/**
 * FINAL: nimeni nu mai poate extinde CombatEvent.
 * Aceasta este o "frunza" in ierarhie.
 */
public final class CombatEvent extends GameEvent {
    private final String attacker;
    private final String defender;
    private final int damage;

    public CombatEvent(String timestamp, String attacker, String defender, int damage) {
        super(timestamp, attacker + " ataca pe " + defender + " cu " + damage + " dmg");
        this.attacker = attacker;
        this.defender = defender;
        this.damage = damage;
    }

    public String getAttacker() { return attacker; }
    public String getDefender() { return defender; }
    public int getDamage() { return damage; }
}
