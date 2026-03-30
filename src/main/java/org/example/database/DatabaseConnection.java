package org.example.database;

// Implements multiple interfaces — like Erou
public class DatabaseConnection implements Connectable, Queryable, Closeable {

    public void connect() {
        System.out.println("Connecting to database...");
    }

    public void query() {
        System.out.println("Executing SQL query...");
    }

    public void close() {
        System.out.println("Closing database connection...");
    }
}
