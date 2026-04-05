package org.example.streaming.defaults;

public class Ex {
    public static void main(String[] args) {
        MusicTrack track = new MusicTrack("Flowers", "Miley Cyrus");
        AudioAd ad = new AudioAd("Coca-Cola");

        // MusicTrack suprascrie play()
        System.out.println(track.play());

        // AudioAd foloseste default play()
        System.out.println(ad.play());

        // Static method - se apeleaza pe interfata, NU pe obiect
        System.out.println("Durata: " + Playable.formatDuration(203));
    }
}
