package org.example;

import org.example.basics.BasicDemo;
import org.example.functional.FunctionalDemo;
import org.example.inheritance.InheritanceDemo;
import org.example.math.impl.Calculator;
import org.example.segregation.SegregationDemo;

public class Main {

    public static void main(String[] args) {

        BasicDemo.run();
        SegregationDemo.run();
        InheritanceDemo.run();
        FunctionalDemo.run();

        // Final result: top-level interfaces from org.example.math
        System.out.println("=== Final: top-level interfaces with Calculator ===");
        Calculator calculator = new Calculator();
        int a = 40, b = 2;
        System.out.println(a + " * " + b + " = " + calculator.multiply(a, b));
        System.out.println(a + " / " + b + " = " + calculator.divide(a, b));
        System.out.println("sqrt(" + a + "² + " + b + "²) = " + calculator.applyFunction(a, b));
    }
}
