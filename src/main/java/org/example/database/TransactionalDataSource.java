package org.example.database;

// Extends DataSource — like MonstruPericulos extends Monstru
public interface TransactionalDataSource extends DataSource {
    void beginTransaction();
}
