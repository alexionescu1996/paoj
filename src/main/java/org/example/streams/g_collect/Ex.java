package org.example.streams.g_collect;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex {
    public static void main(String[] args) {

        List<String> tags = List.of("electronics", "audio", "electronics", "wireless", "audio", "gift");

        List<String> normalised = tags.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("toList   = " + normalised);

        Set<String> uniqueTags = tags.stream()
                .collect(Collectors.toSet());
        System.out.println("toSet    = " + uniqueTags);

        String csv = tags.stream()
                .distinct()
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("joining  = " + csv);

        long count = tags.stream().collect(Collectors.counting());
        System.out.println("counting = " + count);
    }
}
