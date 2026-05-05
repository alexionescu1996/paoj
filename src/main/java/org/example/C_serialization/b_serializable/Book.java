package org.example.C_serialization.b_serializable;

import java.io.Serializable;

// Standard serialization with the Serializable marker interface.
//   - serialVersionUID: pin compatibility between class versions
//     (without it, the JVM generates one and any change breaks old files)
//   - transient: field NOT included in the serialized form
//   - reference to another Serializable: persisted automatically (object graph)
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String title;
    private final Author author;        // -> object graph
    private transient String session;   // -> not serialized

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
        this.session = "tmp-token-" + System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author=" + author + ", session=" + session + "}";
    }
}
