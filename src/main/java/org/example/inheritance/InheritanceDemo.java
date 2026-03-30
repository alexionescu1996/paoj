package org.example.inheritance;

public class InheritanceDemo {

    public static void run() {
        System.out.println("=== Inheritance: GameCharacter extends Attackable + Healable + Movable ===");

        Warrior warrior = new Warrior();
        System.out.println("Playing as: " + warrior.characterName());
        warrior.move("north", 5);
        warrior.attack(60);
        warrior.heal(25);
        System.out.println();
    }
}
