package org.example.database;

public class DatabaseDemo {

    public static void run() {
        System.out.println("=== Database Connection ===");

        System.out.println("-- DatabaseConnection (implements Connectable, Queryable, Closeable) --");
        DatabaseConnection conn = new DatabaseConnection();
        conn.connect();
        conn.query();
        conn.close();

        System.out.println("-- PostgresConnection (implements PooledConnection → TransactionalDataSource + Cacheable) --");
        PostgresConnection pg = new PostgresConnection();
        pg.openConnection();
        pg.beginTransaction();
        pg.cache();
        pg.returnToPool();
        System.out.println();
    }
}
