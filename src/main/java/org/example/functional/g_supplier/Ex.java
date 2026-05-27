package org.example.functional.g_supplier;

import java.util.function.Supplier;

public class Ex {
    public static void main(String[] args) {

        // Supplier<T> = T get(); no input, produces a value
        Supplier<Integer> dice = () -> 1 + (int) (Math.random() * 6);

        System.out.println("roll = " + dice.get());
    }
}
