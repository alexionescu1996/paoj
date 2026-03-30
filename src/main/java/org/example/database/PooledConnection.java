package org.example.database;

// Extends multiple — like Vampir extends MonstruPericulos, Mortal
public interface PooledConnection extends TransactionalDataSource, Cacheable {
    void returnToPool();
}
