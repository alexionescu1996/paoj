package org.example.database;

interface PooledConnection extends Connectable, Cacheable {
    void returnToPool();
}
