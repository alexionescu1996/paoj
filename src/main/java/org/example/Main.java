package org.example;

import org.example.basics.BasicDemo;
import org.example.functional.FunctionalDemo;
import org.example.inheritance.InheritanceDemo;
import org.example.segregation.SegregationDemo;
import org.example.streaming.impl.StreamPlayer;

public class Main {

    public static void main(String[] args) {

        BasicDemo.run();
        SegregationDemo.run();
        InheritanceDemo.run();
        FunctionalDemo.run();

        // Final result: top-level streaming interfaces with StreamPlayer
        System.out.println("=== Final: top-level streaming interfaces ===");
        StreamPlayer player = new StreamPlayer();
        player.play("Stairway to Heaven");
        System.out.println("Matches 'rock'? " + player.matches("rock"));
        System.out.println("Recommendation for 'hype': " + player.recommend("hype"));
        System.out.println("Recommendation for 'focus': " + player.recommend("focus"));
    }
}
