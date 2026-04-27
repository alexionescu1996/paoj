package org.example.B_io.e_bufferedbytes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// BufferedInputStream / BufferedOutputStream wrap byte streams.
// They read/write in chunks under the hood, which is much faster than
// going one byte at a time. Use them when copying or processing binary
// data of any non-trivial size.

public class Ex {
    public static void main(String[] args) throws IOException {
        new File("data").mkdirs();

        // Make a small source file with some bytes.
        try (FileOutputStream out = new FileOutputStream("data/source.bin")) {
            out.write("Hello, buffered I/O!".getBytes());
        }

        // Copy it using buffered streams + a chunk array.
        try (BufferedInputStream  in  = new BufferedInputStream(new FileInputStream("data/source.bin"));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("data/copy.bin"))) {

            byte[] chunk = new byte[256];
            int n;
            while ((n = in.read(chunk)) != -1) {
                out.write(chunk, 0, n);
            }
        }

        System.out.println("source: " + new File("data/source.bin").length() + " bytes");
        System.out.println("copy:   " + new File("data/copy.bin").length() + " bytes");
    }
}
