package org.example.collections.b_list.a_list_interface;

import java.util.ArrayList;
import java.util.List;

public class Ex {
    public static void main(String[] args) {

        List<String> playlist = new ArrayList<>();
        playlist.add("Bohemian Rhapsody");
        playlist.add("Imagine");
        playlist.add("Hey Jude");

        System.out.println("track 0          = " + playlist.get(0));
        System.out.println("indexOf(Imagine) = " + playlist.indexOf("Imagine"));

        playlist.set(1, "Let It Be");
        System.out.println("after replace track 1 = " + playlist);

        playlist.add(1, "Yesterday");
        System.out.println("after insert at 1     = " + playlist);

        playlist.remove(0);
        System.out.println("after remove track 0  = " + playlist);

        List<String> firstTwo = playlist.subList(0, 2);
        System.out.println("first two tracks      = " + firstTwo);
    }
}
