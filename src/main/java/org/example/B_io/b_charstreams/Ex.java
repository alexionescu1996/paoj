package org.example.B_io.b_charstreams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// FileWriter / FileReader: CHARACTER streams for text files.
// They read/write one char at a time and use the platform encoding.
// For binary data (images, etc.) use FileInputStream/FileOutputStream.

public class Ex {
    public static void main(String[] args) throws IOException {
        new java.io.File("data").mkdirs();

        try (FileWriter writer = new FileWriter("data/note.txt")) {
            writer.write("Hello, I/O!\n");
            writer.write("Line two.");
        }

        try (FileReader reader = new FileReader("data/note.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        }
    }
}
