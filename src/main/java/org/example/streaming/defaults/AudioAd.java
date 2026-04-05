package org.example.streaming.defaults;

/**
 * NU suprascrie play() -> foloseste default-ul din Playable.
 */
public class AudioAd implements Playable {
    private String brand;

    public AudioAd(String brand) {
        this.brand = brand;
    }

    @Override
    public String getTitle() { return "Reclama " + brand; }

    // play() vine din default - nu suprascriem
}
