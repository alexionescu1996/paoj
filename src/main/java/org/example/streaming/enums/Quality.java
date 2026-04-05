package org.example.streaming.enums;

/**
 * Enum cu campuri, constructor si metode.
 */
public enum Quality {
    LOW(128),
    NORMAL(256),
    HIGH(320),
    LOSSLESS(1411);

    private final int bitrateKbps;

    Quality(int bitrateKbps) {
        this.bitrateKbps = bitrateKbps;
    }

    public int getBitrateKbps() {
        return bitrateKbps;
    }
}
