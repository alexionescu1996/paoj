package org.example.serialization.externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Externalizable: tu scrii/citesti campurile, in ce ordine si cu ce transformari vrei.
// OBLIGATORIU constructor public fara argumente.
public class Book implements Externalizable {

    private String title;
    private String author;
    private double price;

    public Book() {} // necesar pentru Externalizable

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(title);
        out.writeUTF(author);
        // price nu e scris -> dupa deserializare ramane 0.0
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException {
        // ordinea citirii = ordinea scrierii
        this.title = in.readUTF();
        this.author = in.readUTF();
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', price=" + price + "}";
    }
}
