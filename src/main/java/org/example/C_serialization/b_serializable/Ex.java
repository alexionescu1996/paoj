package org.example.C_serialization.b_serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// Round-trip a Book to disk with ObjectOutputStream / ObjectInputStream.
// JVM defines the binary format and walks the entire object graph.

public class Ex {

    public static void main(String[] args) throws Exception {
        new File("data").mkdirs();

        Book original = new Book("Luceafarul", new Author("Eminescu"));
        System.out.println("before: " + original);

        try (var out = new ObjectOutputStream(new FileOutputStream("data/book.ser"))) {
            out.writeObject(original);
        }

        Book restored;
        try (var in = new ObjectInputStream(new FileInputStream("data/book.ser"))) {
            restored = (Book) in.readObject();
        }

        System.out.println("after:  " + restored);
        // session = null  -> transient was not persisted
        // Author was rebuilt automatically -> object graph
    }
}
