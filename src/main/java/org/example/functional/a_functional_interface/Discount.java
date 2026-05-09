package org.example.functional.a_functional_interface;

@FunctionalInterface
public interface Discount {
    double apply(double price);
}
