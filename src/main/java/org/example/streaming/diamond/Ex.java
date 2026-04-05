package org.example.streaming.diamond;

public class Ex {
    public static void main(String[] args) {
        System.out.println("=== PROBLEMA ROMBULUI (Diamond Problem) ===\n");

        AudioOnlyPodcast audioOnly = new AudioOnlyPodcast("Tech Talks Daily");
        VideoPodcast videoPod = new VideoPodcast("Code Review Show", "Alex si Maria");

        // AudioOnlyPodcast - un singur prepare(), niciun conflict
        System.out.println("--- AudioOnlyPodcast (niciun conflict) ---");
        System.out.println(audioOnly.prepare());
        System.out.println(audioOnly.playAudio());

        // VideoPodcast - CONFLICT rezolvat prin override explicit
        System.out.println("\n--- VideoPodcast (diamond problem rezolvat) ---");
        System.out.println(videoPod.prepare());
        System.out.println(videoPod.playAudio()); // din Audible
        System.out.println(videoPod.playVideo()); // din Visual

        // Polimorfism - VideoPodcast poate fi vazut ca Audible SAU Visual
        System.out.println("\n--- Polimorfism ---");
        Audible asAudible = videoPod;
        Visual asVisual = videoPod;
        System.out.println("Ca Audible: " + asAudible.playAudio());
        System.out.println("Ca Visual:  " + asVisual.playVideo());

        // Ambele referinte apeleaza ACELASI prepare() (cel suprascris de VideoPodcast)
        System.out.println("\nPrin ref Audible: ");
        System.out.println(asAudible.prepare());
        System.out.println("\nPrin ref Visual (acelasi rezultat!):");
        System.out.println(asVisual.prepare());

        /*
         * REGULI Diamond Problem:
         * 1. Daca doua interfete au aceeasi default method -> clasa TREBUIE sa suprascrie
         * 2. Clasa poate apela oricare varianta cu InterfaceName.super.metoda()
         * 3. Daca doar o interfata are default si cealalta e abstracta -> default-ul castiga
         * 4. Clasa concreta castiga intotdeauna peste default din interfata
         */
    }
}
