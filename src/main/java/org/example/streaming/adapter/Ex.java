package org.example.streaming.adapter;

public class Ex {
    public static void main(String[] args) {
        // Sistem vechi
        LegacyMP3Player old = new LegacyMP3Player("bohemian_rhapsody.mp3", 354000);

        // Il impachetam in adapter -> acum respecta interfata moderna
        StreamingPlayer adapted = new MP3Adapter(old);

        System.out.println("Title: " + adapted.getTitle());
        System.out.println("Duration: " + adapted.getDurationSeconds() + "s");
        System.out.println(adapted.play());
    }
}
