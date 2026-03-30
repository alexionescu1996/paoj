package org.example.segregation;

/**
 * Interface Segregation: a class implements only the abilities it actually has.
 * An Archer shouldn't be forced to implement heal(). A Cleric shouldn't attack.
 */
public class SegregationDemo {

    public static void run() {
        System.out.println("=== Segregation: each class implements only its abilities ===");

        Archer archer = new Archer();
        archer.move("north", 3);
        archer.attack(50);

        Cleric cleric = new Cleric();
        cleric.move("south", 2);
        cleric.heal(30);

        Paladin paladin = new Paladin();
        paladin.move("east", 4);
        paladin.attack(40);
        paladin.heal(20);
        System.out.println();
    }
}
