package org.example;

import org.example.basics.BasicDemo;
import org.example.functional.FunctionalDemo;
import org.example.hero.impl.IronMan;
import org.example.inheritance.InheritanceDemo;
import org.example.segregation.SegregationDemo;

public class Main {

    public static void main(String[] args) {

        BasicDemo.run();
        SegregationDemo.run();
        InheritanceDemo.run();
        FunctionalDemo.run();

        // Final result: top-level hero interfaces with IronMan
        System.out.println("=== Final: top-level hero interfaces ===");
        IronMan ironMan = new IronMan();
        ironMan.fly(15000);
        ironMan.shoot(98);
    }
}
