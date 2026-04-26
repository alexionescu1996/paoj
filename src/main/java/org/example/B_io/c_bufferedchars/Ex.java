package org.example.B_io.c_bufferedchars;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// BufferedReader / BufferedWriter wrap another reader/writer.
// They read/write in chunks, which is much faster than one char at a time,
// and BufferedReader gives us readLine() for line-based input.

public class Ex {
    public static void main(String[] args) throws IOException {
        new java.io.File("data").mkdirs();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/lines.txt"))) {
            writer.write("first line");
            writer.newLine();
            writer.write("second line");
            writer.newLine();
            writer.write("third line");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("data/lines.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
