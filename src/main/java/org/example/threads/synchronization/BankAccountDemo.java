package org.example.threads.synchronization;

// synchronized garanteaza ca verificarea + modificarea formeaza o operatie atomica.
public class BankAccountDemo {

    static class Account {
        private int balance;
        Account(int initial) { this.balance = initial; }

        synchronized void deposit(int amount)  { balance += amount; }
        synchronized boolean withdraw(int amount) {
            if (balance < amount) return false;
            balance -= amount;
            return true;
        }
        synchronized int getBalance() { return balance; }
    }

    public static void main(String[] args) throws InterruptedException {
        Account a = new Account(1000);

        Thread d = new Thread(() -> { for (int i = 0; i < 1000; i++) a.deposit(10); });
        Thread w = new Thread(() -> { for (int i = 0; i < 1000; i++) a.withdraw(10); });

        d.start(); w.start();
        d.join();  w.join();

        System.out.println("sold: " + a.getBalance() + " (asteptam 1000)");
    }
}
