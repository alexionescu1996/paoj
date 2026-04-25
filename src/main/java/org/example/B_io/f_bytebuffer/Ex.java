package org.example.B_io.f_bytebuffer;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;

// ByteBuffer (java.nio): a fixed-size container of bytes with a position
// and a limit. Lets us read/modify bytes by absolute index without a loop
// counter, and is the bridge to NIO channels for fast bulk I/O.
//
// Demo: same image inversion as the byte-stream lesson, but using a
// ByteBuffer to manipulate the pixels.

public class Ex {
    public static void main(String[] args) throws IOException {
        new File("data").mkdirs();
        Path input  = Path.of("data/in2.bmp");
        Path output = Path.of("data/out2.bmp");

        // Make a green test image.
        BufferedImage img = new BufferedImage(16, 16, BufferedImage.TYPE_3BYTE_BGR);
        for (int y = 0; y < 16; y++) {
            for (int x = 0; x < 16; x++) {
                img.setRGB(x, y, Color.GREEN.getRGB());
            }
        }
        ImageIO.write(img, "bmp", input.toFile());

        // Load all bytes into a ByteBuffer.
        ByteBuffer buffer = ByteBuffer.wrap(Files.readAllBytes(input));

        // Skip the 54-byte BMP header, invert each pixel byte by index.
        // (~b is the same as 255 - (b & 0xff) for a byte.)
        for (int i = 54; i < buffer.limit(); i++) {
            buffer.put(i, (byte) ~buffer.get(i));
        }

        Files.write(output, buffer.array());
        System.out.println("Inverted image saved to " + output.toAbsolutePath());
    }
}
