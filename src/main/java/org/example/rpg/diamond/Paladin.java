package org.example.rpg.diamond;

/**
 * PROBLEMA ROMBULUI (Diamond Problem):
 *
 * Paladin implementeaza AMBELE interfete: Warrior si Healer.
 * Ambele au "default String prepare()" -> CONFLICT!
 *
 * Solutie: Paladin TREBUIE sa suprascrie prepare() explicit.
 * Daca nu o face -> eroare de compilare!
 *
 * In interiorul suprascrierii, poate apela oricare varianta:
 *   - Warrior.super.prepare()
 *   - Healer.super.prepare()
 *   - sau implementare complet noua
 */
public class Paladin implements Warrior, Healer {
    private String name;

    public Paladin(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * OBLIGATORIU: trebuie sa suprascriem prepare() deoarece
     * exista conflict intre Warrior.prepare() si Healer.prepare().
     *
     * Putem apela ambele variante prin InterfaceName.super.metoda()
     */
    @Override
    public String prepare() {
        // Apelam AMBELE implementari din interfete
        String warriorPrep = Warrior.super.prepare();
        String healerPrep = Healer.super.prepare();
        return "=== Paladin se pregateste pe ambele fronturi ===\n"
                + "  [Warrior] " + warriorPrep + "\n"
                + "  [Healer]  " + healerPrep;
    }

    // fight() vine din Warrior - fara conflict
    // heal() vine din Healer - fara conflict
}
