package org.example.streaming;

// Implements deep interface — like Dracula implements Vampir
public class NetflixSeries implements OriginalSeries {

    public void load() {
        System.out.println("Loading series metadata...");
    }

    public void streamHD() {
        System.out.println("Streaming in 4K HDR...");
    }

    public void review() {
        System.out.println("Submitting user review...");
    }

    public void bingeWatch() {
        System.out.println("Auto-playing next episode...");
    }
}
