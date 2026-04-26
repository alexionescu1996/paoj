package org.example.B_io.d_bytestreams;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// FileInputStream / FileOutputStream: BYTE streams.
// Use them for any binary data - images, audio, anything not text.
//
// Demo: invert the colors of a BMP image, byte by byte.
// BMP is uncompressed, so flipping pixel bytes flips the colors.
// (JPG would not work - it is compressed.)

public class Ex {
    public static void main(String[] args) throws IOException {
        new File("data").mkdirs();
        File input  = new File("data/in.bmp");
        File output = new File("data/out.bmp");

        // 1. Make a small red image so we have something to invert.
        BufferedImage img = new BufferedImage(16, 16, BufferedImage.TYPE_3BYTE_BGR);
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                img.setRGB(x, y, Color.RED.getRGB());
            }
        }
        ImageIO.write(img, "bmp", input);

        // 2. Read bytes with FileInputStream, invert, write with FileOutputStream.
        try (FileInputStream  in  = new FileInputStream(input);
             FileOutputStream out = new FileOutputStream(output)) {

            // BMP: first 54 bytes are the header - copy them as-is.
            out.write(in.readNBytes(54));

            // Pixel bytes: flip each one (255 - b inverts the color).
            int b;
            while ((b = in.read()) != -1) {
                out.write(255 - b);
            }
        }

        System.out.println("Original: " + input.getAbsolutePath());
        System.out.println("Inverted: " + output.getAbsolutePath());
    }
}
