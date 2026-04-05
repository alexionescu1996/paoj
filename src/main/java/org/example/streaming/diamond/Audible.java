package org.example.streaming.diamond;

/**
 * Interfata Audible - are o default method prepare().
 * Reprezinta continut audio (muzica, podcast audio).
 */
public interface Audible {

    String getTitle();

    default String prepare() {
        return getTitle() + " -> se incarca buffer-ul audio...";
    }

    default String playAudio() {
        return getTitle() + " -> reda audio!";
    }
}
