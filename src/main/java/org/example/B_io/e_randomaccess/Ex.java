package org.example.B_io.e_randomaccess;

import java.io.IOException;
import java.io.RandomAccessFile;

// RandomAccessFile: read AND write at any offset in a file.
// Unlike streams, you can seek freely - perfect for fixed-size records.
// Mode "r" is read-only, "rw" is read-write.

public class Ex {
    public static void main(String[] args) throws IOException {
        new java.io.File("data").mkdirs();

        try (RandomAccessFile raf = new RandomAccessFile("data/scores.dat", "rw")) {
            // Write 5 ints sequentially: 100, 200, 300, 400, 500
            for (int i = 1; i <= 5; i++) {
                raf.writeInt(i * 100);
            }

            // Jump to the third int and overwrite it.
            raf.seek(2 * Integer.BYTES);
            raf.writeInt(999);

            // Read everything back from the start.
            raf.seek(0);
            for (int i = 0; i < 5; i++) {
                System.out.println("score[" + i + "] = " + raf.readInt());
            }
        }
    }
}
