package org.example.streams.f_collect;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex {
    public static void main(String[] args) {

        // collect: terminal op that accumulates into a result
        List<String> tags = List.of("audio", "electronics", "audio", "gift");

        Set<String> unique = tags.stream().collect(Collectors.toSet());
        String joined = tags.stream().collect(Collectors.joining(", "));

        System.out.println("unique = " + unique);
        System.out.println("joined = " + joined);
    }
}
