package org.example.functional.a_functional_interface;

// @FunctionalInterface = exactly one abstract method (SAM)
@FunctionalInterface
public interface Discount {
    double apply(double price);
}
