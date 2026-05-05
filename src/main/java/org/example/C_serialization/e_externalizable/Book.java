package org.example.C_serialization.e_externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Externalizable: WE write/read the fields, in our chosen order, with
// any transformations we want. REQUIRES a public no-arg constructor
// (the JVM calls it before readExternal).
//
// Serializable vs Externalizable:
//   Serializable    - marker interface, JVM does it all, less control
//   Externalizable  - we implement writeExternal/readExternal, full control,
//                     more code, no-arg constructor mandatory
public class Book implements Externalizable {

    private String title;
    private String author;
    private double price;

    public Book() {} // required by Externalizable

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(title);
        out.writeUTF(author);
        // price is intentionally NOT written -> stays 0.0 after deserialization
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException {
        // read order MUST match write order
        this.title = in.readUTF();
        this.author = in.readUTF();
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', price=" + price + "}";
    }
}
