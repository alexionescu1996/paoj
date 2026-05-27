package org.example.functional.a_functional_interface;

public class Ex {
    public static void main(String[] args) {

        // a lambda is a shorthand implementation of a SAM
        Discount halfOff = price -> price * 0.5;

        System.out.println("100 -> " + halfOff.apply(100));
    }
}
