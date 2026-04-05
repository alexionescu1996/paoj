package org.example.streaming.diamond;

public class Ex {
    public static void main(String[] args) {
        VideoPodcast vp = new VideoPodcast("Tech Review");

        // prepare() combina ambele variante
        System.out.println(vp.prepare());

        // Polimorfism - poate fi vazut ca Audible SAU Visual
        Audible a = vp;
        Visual v = vp;
        // Ambele apeleaza ACELASI prepare() (cel suprascris)
        System.out.println("\nPrin Audible: " + a.prepare());
        System.out.println("Prin Visual:  " + v.prepare());
    }
}
