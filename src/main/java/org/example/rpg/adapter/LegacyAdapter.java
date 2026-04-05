package org.example.rpg.adapter;

/**
 * ADAPTER PATTERN:
 * Adapteaza LegacyCombatSystem (cod vechi) la interfata ModernCombatant (cod nou).
 *
 * Adapter-ul "wraps" (impacheteaza) obiectul vechi si ii traduce metodele
 * la interfata noua, fara sa modifice codul original.
 *
 * Cand folosim:
 *   - avem cod vechi (legacy) care functioneaza bine
 *   - avem o interfata noua pe care trebuie sa o respectam
 *   - NU vrem/putem modifica codul vechi
 */
public class LegacyAdapter implements ModernCombatant {

    // Adapter-ul contine o referinta la obiectul vechi (composition)
    private final LegacyCombatSystem legacyUnit;

    public LegacyAdapter(LegacyCombatSystem legacyUnit) {
        this.legacyUnit = legacyUnit;
    }

    @Override
    public String getName() {
        // Traducere: getUnitName() -> getName()
        return legacyUnit.getUnitName();
    }

    @Override
    public int getAttackPower() {
        // Traducere: getStr() -> getAttackPower()
        return legacyUnit.getStr();
    }

    @Override
    public int getHealth() {
        // Traducere: getHp() -> getHealth()
        return legacyUnit.getHp();
    }

    @Override
    public String attack(ModernCombatant target) {
        // Traducere: strike() (returneaza int) -> attack() (returneaza String)
        int damage = legacyUnit.strike();
        return getName() + " ataca pe " + target.getName() + " cu " + damage + " damage! (via adapter)";
    }
}
