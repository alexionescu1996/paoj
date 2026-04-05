package org.example.rpg.diamond;

/**
 * PureWarrior implementeaza DOAR Warrior -> niciun conflict.
 * Foloseste default method-ul prepare() fara probleme.
 */
public class PureWarrior implements Warrior {
    private String name;

    public PureWarrior(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    // prepare() si fight() vin din Warrior default - fara conflict
}
