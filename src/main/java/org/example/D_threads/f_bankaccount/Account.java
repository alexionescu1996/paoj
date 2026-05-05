package org.example.D_threads.f_bankaccount;

// synchronized makes the check + modification atomic from the point of
// view of other threads - no other deposit/withdraw can interleave.
public class Account {

    private int balance;

    public Account(int initial) { this.balance = initial; }

    public synchronized void deposit(int amount) {
        balance += amount;
    }

    public synchronized boolean withdraw(int amount) {
        if (balance < amount) return false;
        balance -= amount;
        return true;
    }

    public synchronized int getBalance() {
        return balance;
    }
}
