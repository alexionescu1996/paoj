package org.example.rpg.marker;

import org.example.rpg.enums.Element;
import org.example.rpg.enums.Rarity;

/**
 * Weapon implementeaza Cloneable (pt. duplicare) + Tradeable + Enchantable (marker interfaces).
 *
 * Cloneable = marker interface din java.lang.
 * Daca NU implementezi Cloneable si apelezi clone(), primesti CloneNotSupportedException.
 */
public class Weapon extends GameItem implements Cloneable, Tradeable, Enchantable {
    private int damage;
    private Element element;

    public Weapon(String name, Rarity rarity, int damage, Element element) {
        super(name, rarity);
        this.damage = damage;
        this.element = element;
    }

    public int getDamage() {
        return damage;
    }

    public Element getElement() {
        return element;
    }

    /**
     * Suprascriem clone() pentru a-l face public.
     * Object.clone() este protected - trebuie suprascris pentru acces din exterior.
     * Fara "implements Cloneable" -> CloneNotSupportedException la runtime!
     */
    @Override
    public Weapon clone() {
        try {
            return (Weapon) super.clone(); // shallow copy
        } catch (CloneNotSupportedException e) {
            // Nu se va intampla niciodata daca implementam Cloneable
            throw new AssertionError("Clone not supported - but we implement Cloneable!", e);
        }
    }

    @Override
    public String toString() {
        return name + " [" + rarity + "] (dmg=" + damage + ", " + element + ")";
    }
}
