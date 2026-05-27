package org.example.functional.f_consumer;

import java.util.List;
import java.util.function.Consumer;

public class Ex {
    public static void main(String[] args) {

        // Consumer<T> = void accept(T)
        Consumer<String> notify = email -> System.out.println("sending to " + email);

        List<String> subscribers = List.of("alice@example.com", "bob@example.com");
        subscribers.forEach(notify);
    }
}
