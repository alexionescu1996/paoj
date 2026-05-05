package org.example.D_threads.f_bankaccount;

public class Ex {

    public static void main(String[] args) throws InterruptedException {
        Account a = new Account(1000);

        Thread d = new Thread(() -> { for (int i = 0; i < 1000; i++) a.deposit(10); });
        Thread w = new Thread(() -> { for (int i = 0; i < 1000; i++) a.withdraw(10); });

        d.start(); w.start();
        d.join();  w.join();

        System.out.println("balance: " + a.getBalance() + " (expected 1000)");
    }
}
