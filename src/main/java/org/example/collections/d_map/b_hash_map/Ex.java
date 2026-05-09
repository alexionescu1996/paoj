package org.example.collections.d_map.b_hash_map;

import java.util.HashMap;

public class Ex {
    public static void main(String[] args) {

        HashMap<String, Integer> votes = new HashMap<>();

        String[] ballots = {"Alice", "Bob", "Alice", "Carol", "Bob", "Alice", "Bob"};

        for (String candidate : ballots) {
            votes.merge(candidate, 1, Integer::sum);
        }

        System.out.println("vote tally = " + votes);

        votes.putIfAbsent("Dave", 0);
        System.out.println("after registering Dave with 0 votes = " + votes);

        Integer eveVotes = votes.getOrDefault("Eve", 0);
        System.out.println("votes for Eve (not on ballot) = " + eveVotes);
    }
}
