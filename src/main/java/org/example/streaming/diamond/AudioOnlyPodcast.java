package org.example.streaming.diamond;

/**
 * AudioOnlyPodcast implementeaza DOAR Audible -> niciun conflict.
 * Foloseste default method-ul prepare() fara probleme.
 */
public class AudioOnlyPodcast implements Audible {
    private String title;

    public AudioOnlyPodcast(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    // prepare() si playAudio() vin din Audible default - fara conflict
}
