package org.example.inheritance;

public class InheritanceDemo {

    public static void run() {
        System.out.println("=== Inheritance: Superhero extends Flyable + Shootable ===");

        IronMan ironMan = new IronMan();
        System.out.println("Hero: " + ironMan.heroName());
        ironMan.fly(12000);
        ironMan.shoot(90);
        System.out.println();
    }
}
