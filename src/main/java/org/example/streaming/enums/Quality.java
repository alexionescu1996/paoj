package org.example.streaming.enums;

/**
 * Enum cu metoda abstracta implementata diferit de fiecare constanta.
 * Calitatea stream-ului - fiecare nivel are bitrate si consum de date diferit.
 */
public enum Quality {
    LOW {
        @Override
        public String formatInfo() {
            return "128 kbps - economie de date";
        }

        @Override
        public int bitrateKbps() {
            return 128;
        }
    },
    NORMAL {
        @Override
        public String formatInfo() {
            return "256 kbps - calitate standard";
        }

        @Override
        public int bitrateKbps() {
            return 256;
        }
    },
    HIGH {
        @Override
        public String formatInfo() {
            return "320 kbps - calitate inalta";
        }

        @Override
        public int bitrateKbps() {
            return 320;
        }
    },
    LOSSLESS {
        @Override
        public String formatInfo() {
            return "1411 kbps - calitate CD, fara pierderi";
        }

        @Override
        public int bitrateKbps() {
            return 1411;
        }
    };

    /**
     * Metoda abstracta - fiecare constanta TREBUIE sa o implementeze.
     */
    public abstract String formatInfo();

    public abstract int bitrateKbps();

    /**
     * Metoda concreta comuna tuturor constantelor.
     * Calculeaza consumul de date pentru o durata data (in minute).
     */
    public double dataMB(int minutes) {
        return (bitrateKbps() / 8.0) * 60 * minutes / 1024.0;
    }
}
