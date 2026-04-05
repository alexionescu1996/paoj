package org.example.rpg.defaults;

/**
 * Interfata cu DEFAULT METHODS si STATIC METHODS.
 *
 * Default methods (Java 8+):
 *   - permit implementare directa in interfata
 *   - clasele care implementeaza pot sa le suprascrie sau nu
 *   - rezolva problema: "cum adaug metode noi la o interfata fara sa stric toate clasele existente?"
 *
 * Static methods in interfata:
 *   - apartin interfetei, NU pot fi suprascrise
 *   - se apeleaza prin InterfaceName.metoda()
 */
public interface Combatant {

    // Metoda abstracta clasica - TREBUIE implementata
    String getName();
    int getAttackPower();
    int getHealth();

    /**
     * DEFAULT METHOD - are implementare, dar poate fi suprascris.
     */
    default String attack(Combatant target) {
        int damage = calculateDamage(target);
        return getName() + " ataca pe " + target.getName() + " cu " + damage + " damage!";
    }

    /**
     * Alt default method - calcul standard de damage.
     */
    default int calculateDamage(Combatant target) {
        return Math.max(1, getAttackPower());
    }

    /**
     * Default method care apeleaza alta default method.
     */
    default boolean canDefeat(Combatant target) {
        return getAttackPower() >= target.getHealth();
    }

    /**
     * STATIC METHOD - utilitara, apartine interfetei.
     * NU poate fi suprascris. Se apeleaza: Combatant.comparePower(a, b)
     */
    static Combatant stronger(Combatant a, Combatant b) {
        return a.getAttackPower() >= b.getAttackPower() ? a : b;
    }

    /**
     * Static factory method in interfata.
     */
    static Combatant createDummy(String name, int attack, int health) {
        return new Combatant() {
            @Override
            public String getName() { return name; }

            @Override
            public int getAttackPower() { return attack; }

            @Override
            public int getHealth() { return health; }
        };
    }
}
