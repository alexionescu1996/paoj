package org.example.database;

// Implements deep interface — like Dracula implements Vampir
public class PostgresConnection implements PooledConnection {

    public void openConnection() {
        System.out.println("Opening connection to PostgreSQL...");
    }

    public void beginTransaction() {
        System.out.println("BEGIN TRANSACTION;");
    }

    public void cache() {
        System.out.println("Caching query results in memory...");
    }

    public void returnToPool() {
        System.out.println("Returning connection to pool...");
    }
}
