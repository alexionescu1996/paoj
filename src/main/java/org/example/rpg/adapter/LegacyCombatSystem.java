package org.example.rpg.adapter;

/**
 * Sistem vechi (legacy) de combat - nu respecta interfata noua.
 * Are metode cu nume diferite si logica diferita.
 *
 * Aceasta clasa simuleaza un cod vechi pe care NU il putem modifica
 * (e.g., vine dintr-o librarie externa).
 */
public class LegacyCombatSystem {
    private String unitName;
    private int str;  // strength - nu "attackPower"
    private int hp;   // hit points - nu "health"

    public LegacyCombatSystem(String unitName, int str, int hp) {
        this.unitName = unitName;
        this.str = str;
        this.hp = hp;
    }

    /**
     * Metoda veche de atac - returneaza damage, nu String.
     */
    public int strike() {
        return (int) (str * 1.2);
    }

    /**
     * Metoda veche - ia damage.
     */
    public void receiveDamage(int dmg) {
        hp -= dmg;
        System.out.println(unitName + " a primit " + dmg + " damage. HP ramas: " + hp);
    }

    public String getUnitName() { return unitName; }
    public int getStr() { return str; }
    public int getHp() { return hp; }
}
