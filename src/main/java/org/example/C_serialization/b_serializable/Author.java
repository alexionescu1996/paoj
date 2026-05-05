package org.example.C_serialization.b_serializable;

import java.io.Serializable;

// Referenced by Book - must also be Serializable, otherwise writing
// Book throws NotSerializableException (see package c_notserializable).
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String name;

    public Author(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" + name + "}";
    }
}
