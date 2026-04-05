package org.example.streaming.adapter;

import java.util.List;

public class Ex {
    public static void main(String[] args) {
        System.out.println("=== ADAPTER PATTERN ===\n");

        // Sistem VECHI - un MP3 player care nu respecta interfata noua
        LegacyMP3Player oldPlayer = new LegacyMP3Player(
                "bohemian_rhapsody.mp3", "Queen", 354000);
        System.out.println("--- Sistem legacy (metode vechi) ---");
        System.out.println("File: " + oldPlayer.getFileName());
        System.out.println("Performer: " + oldPlayer.getPerformer());
        System.out.println("Length: " + oldPlayer.getLengthMs() + " ms");
        oldPlayer.startPlayback();
        oldPlayer.stopPlayback();

        // Sistem NOU
        ModernStreamPlayer modernPlayer = new ModernStreamPlayer(
                "Flowers", "Miley Cyrus", 200);

        // ADAPTER: impachetam player-ul vechi in adapter
        StreamingPlayer adaptedPlayer = new MP3Adapter(oldPlayer);

        // Acum ambele respecta ACEEASI interfata!
        System.out.println("\n--- Ambele playere prin interfata moderna ---");
        List<StreamingPlayer> queue = List.of(modernPlayer, adaptedPlayer);

        for (StreamingPlayer player : queue) {
            System.out.printf("%-25s | %-15s | %3ds%n",
                    player.getTitle(), player.getArtist(), player.getDurationSeconds());
        }

        // Pot fi redate prin aceeasi interfata!
        System.out.println("\n--- Redare coada ---");
        for (StreamingPlayer player : queue) {
            System.out.println(player.play());
        }

        System.out.println("\n--- Pauza ---");
        for (StreamingPlayer player : queue) {
            System.out.println(player.pause());
        }

        /*
         * AVANTAJELE Adapter Pattern:
         * 1. Nu modificam codul vechi (LegacyMP3Player ramane intact)
         * 2. Codul nou nu stie ca lucreaza cu un player vechi
         * 3. Putem integra oricand formate/sisteme externe/legacy
         * 4. Respectam Open/Closed Principle (open for extension, closed for modification)
         */
    }
}
