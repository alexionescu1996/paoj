package org.example.streaming.diamond;

/**
 * Interfata Visual - are ACEEASI default method prepare() ca si Audible!
 * Aceasta creeaza PROBLEMA ROMBULUI (Diamond Problem).
 * Reprezinta continut video (videoclip, film).
 */
public interface Visual {

    String getTitle();

    default String prepare() {
        return getTitle() + " -> se incarca buffer-ul video + subtitrarile...";
    }

    default String playVideo() {
        return getTitle() + " -> reda video!";
    }
}
