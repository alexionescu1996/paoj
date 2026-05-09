package org.example.functional.f_consumer;

import java.util.List;
import java.util.function.Consumer;

public class Ex {
    public static void main(String[] args) {

        Consumer<String> log = email -> System.out.println("[log] dispatching to " + email);
        Consumer<String> sendEmail = email -> System.out.println("    --> email sent to " + email);

        log.accept("alice@example.com");

        Consumer<String> logThenSend = log.andThen(sendEmail);
        logThenSend.accept("bob@example.com");

        List<String> subscribers = List.of(
                "alice@example.com",
                "bob@example.com",
                "carol@example.com"
        );
        System.out.println("\n--- newsletter dispatch ---");
        subscribers.forEach(logThenSend);
    }
}
