package org.example.functional.a_functional_interface;

// @FunctionalInterface — must declare exactly ONE abstract method (SAM);
// the annotation is optional but lets the compiler enforce the rule.
@FunctionalInterface
public interface Discount {
    double apply(double price);
}
