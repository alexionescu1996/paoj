package org.example.functional.g_supplier;

import java.util.UUID;
import java.util.function.Supplier;

public class Ex {
    public static void main(String[] args) {

        Supplier<String> welcomeBanner = () -> "=== Welcome to the Store ===";
        System.out.println(welcomeBanner.get());

        Supplier<String> orderIdGenerator = () -> "ORD-" + UUID.randomUUID();
        System.out.println("order 1 = " + orderIdGenerator.get());
        System.out.println("order 2 = " + orderIdGenerator.get());

        Supplier<Integer> diceRoll = () -> 1 + (int) (Math.random() * 6);
        System.out.println("dice roll = " + diceRoll.get());
        System.out.println("dice roll = " + diceRoll.get());
    }
}
