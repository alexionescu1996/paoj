package org.example.functional.g_supplier;

import java.util.UUID;
import java.util.function.Supplier;

public class Ex {
    public static void main(String[] args) {

        Supplier<String> hello = () -> "hello world";
        System.out.println(hello.get());

        Supplier<String> idGenerator = () -> UUID.randomUUID().toString();
        System.out.println("id 1 = " + idGenerator.get());
        System.out.println("id 2 = " + idGenerator.get());

        Supplier<Double> randomScore = Math::random;
        System.out.println("random = " + randomScore.get());
    }
}
