package org.example.threads.synchronization;

// Domeniu mai realist: un cont bancar pe care doua thread-uri fac
// depuneri si retrageri concurent. Fara sincronizare, soldul final
// poate fi gresit si retragerile pot duce in negativ chiar daca
// verificarea "balance >= amount" pare corecta.
//
// Cu synchronized pe deposit/withdraw, fiecare operatie este atomica
// din punctul de vedere al celorlalte thread-uri.
public class BankAccountDemo {

    static class BankAccount {
        private int balance;

        BankAccount(int initial) { this.balance = initial; }

        // synchronized garanteaza ca verificarea (balance >= amount) si
        // modificarea (balance -= amount) se intampla impreuna, fara ca
        // alt thread sa "se strecoare" intre ele.
        synchronized void deposit(int amount) {
            balance += amount;
        }

        synchronized boolean withdraw(int amount) {
            if (balance >= amount) {
                balance -= amount;
                return true;
            }
            return false;
        }

        synchronized int getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(1000);

        // Un thread depune mereu 10
        Thread depositor = new Thread(() -> {
            for (int i = 0; i < 1000; i++) account.deposit(10);
        }, "depositor");

        // Alt thread retrage mereu 10
        Thread withdrawer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) account.withdraw(10);
        }, "withdrawer");

        depositor.start();
        withdrawer.start();
        depositor.join();
        withdrawer.join();

        // Plecam de la 1000, depunem 10*1000 = 10_000, retragem 10*1000 = 10_000.
        // Soldul final corect: 1000.
        System.out.println("Sold final: " + account.getBalance() + " (asteptam 1000)");
    }
}
