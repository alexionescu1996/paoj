package org.example.streaming.defaults;

public class Ex {
    public static void main(String[] args) {
        System.out.println("=== Default Methods & Static Methods in Interfaces ===\n");

        MusicTrack track = new MusicTrack("Blinding Lights", "The Weeknd", 203);
        AudioAd ad = new AudioAd("Coca-Cola", 15);

        // MusicTrack suprascrie play() -> comportament custom
        System.out.println("--- MusicTrack (override play) ---");
        System.out.println(track.play());

        // AudioAd NU suprascrie play() -> foloseste default
        System.out.println("\n--- AudioAd (default play) ---");
        System.out.println(ad.play());

        // Default method: isLongerThan
        System.out.println("\n--- Default method: isLongerThan ---");
        System.out.println(track.getTitle() + " mai lung decat reclama? "
                + track.isLongerThan(ad));

        // Static method pe interfata
        System.out.println("\n--- Static method: Playable.longer() ---");
        Playable longer = Playable.longer(track, ad);
        System.out.println("Mai lung: " + longer.getTitle() + " (" + longer.formatDuration() + ")");

        // Static factory method
        System.out.println("\n--- Static factory: Playable.createPreview() ---");
        Playable preview = Playable.createPreview("Blinding Lights", "The Weeknd");
        System.out.println(preview.play());

        // Recommendable static method
        System.out.println("\n--- Recommendable static method ---");
        Recommendable.logRecommendation("Ai ascultat Pop, incearca si R&B!");

        // IMPORTANT: static methods nu se mostenesc!
        // track.longer(...)  // NU COMPILEAZA
        // Trebuie: Playable.longer(...)
    }
}
