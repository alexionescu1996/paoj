package org.example.C_serialization.a_intro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Bridge from B_io. Last week we wrote bytes and characters to files.
// Now we have a Book OBJECT with multiple fields - how do we persist it?
//
// First attempt with what we already know: invent a text format,
// write each field line by line, parse it back on read.
// Works for this simple case but does not scale - that is what
// serialization (next packages) will solve for us.

public class Ex {

    record Book(String title, String author, double price) {}

    public static void main(String[] args) throws IOException {
        new File("data").mkdirs();
        File file = new File("data/book.txt");

        Book original = new Book("Luceafarul", "Eminescu", 49.9);

        // WRITE: one field per line, in a fixed order we agree on.
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
            out.write(original.title());            out.newLine();
            out.write(original.author());           out.newLine();
            out.write(String.valueOf(original.price()));
        }

        // READ: must remember the same order and parse each type ourselves.
        Book restored;
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String title  = in.readLine();
            String author = in.readLine();
            double price  = Double.parseDouble(in.readLine()); // NumberFormatException possible
            restored = new Book(title, author, price);
        }

        System.out.println("before: " + original);
        System.out.println("after:  " + restored);

        // Problems with this approach:
        //   1. We define and remember the format on both sides.
        //   2. Every type needs its own parsing (Double, Integer, LocalDate...).
        //   3. If a field contains a newline, the format breaks.
        //   4. If Book holds another object (Author, List<Tag>...), it gets ugly fast.
        //
        // Next: ObjectOutputStream / ObjectInputStream do all this for us.
        // The JVM defines the format, handles types, and walks the entire
        // object graph automatically.
    }
}
