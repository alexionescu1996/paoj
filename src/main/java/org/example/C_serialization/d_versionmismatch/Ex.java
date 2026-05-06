package org.example.C_serialization.d_versionmismatch;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;

// When the serialVersionUID in the stream does not match the local class,
// readObject throws InvalidClassException. Real-life trigger: write with
// version 1 of the class, change the class, try to read the old file.
// Here we simulate it by redirecting BookV1 to BookV2 on read.

public class Ex {

    static class BookV1 implements Serializable {
        private static final long serialVersionUID = 1L;
    }

    static class BookV2 implements Serializable {
        private static final long serialVersionUID = 2L;
    }

    // Custom ObjectInputStream that pretends BookV1 in the file is actually
    // BookV2. Needed only to simulate two "versions" of the class in one run.
    static class RedirectingInputStream extends ObjectInputStream {
        RedirectingInputStream(InputStream in) throws IOException {
            super(in);
        }

        @Override
        protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
            if (desc.getName().equals(BookV1.class.getName())) {
                return BookV2.class;
            }
            return super.resolveClass(desc);
        }
    }

    public static void main(String[] args) throws Exception {
        // Write with BookV1 (UID = 1).
        var bytes = new ByteArrayOutputStream();
        try (var out = new ObjectOutputStream(bytes)) {
            out.writeObject(new BookV1());
        }

        // Read pretending it is BookV2 (UID = 2) -> mismatch -> exception.
        var input = new ByteArrayInputStream(bytes.toByteArray());
        try (var in = new RedirectingInputStream(input)) {
            in.readObject();
        } catch (InvalidClassException e) {
            System.out.println("InvalidClassException: " + e.getMessage());
        }
    }
}
