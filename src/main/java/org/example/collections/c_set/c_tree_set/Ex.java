package org.example.collections.c_set.c_tree_set;

import java.util.Comparator;
import java.util.TreeSet;

public class Ex {
    public static void main(String[] args) {

        TreeSet<Integer> leaderboard = new TreeSet<>();
        leaderboard.add(2400);
        leaderboard.add(1200);
        leaderboard.add(1800);
        leaderboard.add(950);
        leaderboard.add(2100);

        System.out.println("scores (natural order) = " + leaderboard);
        System.out.println("lowest score  = " + leaderboard.first());
        System.out.println("highest score = " + leaderboard.last());
        System.out.println("scores below 1800 = " + leaderboard.headSet(1800));
        System.out.println("scores >= 1800    = " + leaderboard.tailSet(1800));

        TreeSet<String> rankByName = new TreeSet<>(Comparator.reverseOrder());
        rankByName.add("alice");
        rankByName.add("bob");
        rankByName.add("carol");
        System.out.println("players reverse-alpha = " + rankByName);
    }
}
