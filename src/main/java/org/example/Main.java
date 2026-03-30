package org.example;

import org.example.math.impl.Calculator;
import org.example.steps.Step1_InterfaceBasics;
import org.example.steps.Step2_InterfaceSeparation;
import org.example.steps.Step3_InterfaceInheritance;
import org.example.steps.Step4_FunctionalInterface;

public class Main {

    public static void main(String[] args) {

        // Progressive steps — each builds on the previous one
        Step1_InterfaceBasics.run();
        Step2_InterfaceSeparation.run();
        Step3_InterfaceInheritance.run();
        Step4_FunctionalInterface.run();

        // Final result: use the extracted top-level interfaces + Calculator
        System.out.println("=== Final: Top-level interfaces with Calculator ===");
        Calculator calculator = new Calculator();
        int a = 40, b = 2;
        System.out.println(a + " * " + b + " = " + calculator.multiply(a, b));
        System.out.println(a + " / " + b + " = " + calculator.divide(a, b));
        System.out.println("sqrt(" + a + "² + " + b + "²) = " + calculator.applyFunction(a, b));
    }
}
