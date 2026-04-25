package org.example.B_io.a_file;

import java.io.File;
import java.io.IOException;

// java.io.File represents a PATH on the filesystem.
// Just having a File object does not mean the file exists -
// you call methods on it to create, query, list, delete.

public class Ex {
    public static void main(String[] args) throws IOException {
        File dir = new File("data");
        dir.mkdirs();

        File file = new File(dir, "hello.txt");
        boolean created = file.createNewFile();

        System.out.println("Path:    " + file.getAbsolutePath());
        System.out.println("Exists:  " + file.exists());
        System.out.println("Is file: " + file.isFile());
        System.out.println("Size:    " + file.length() + " bytes");
        System.out.println("Created: " + created);

        System.out.println("\nFiles in " + dir.getName() + ":");
        for (String name : dir.list()) {
            System.out.println("  " + name);
        }
    }
}
