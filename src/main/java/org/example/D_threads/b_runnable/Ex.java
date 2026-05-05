package org.example.D_threads.b_runnable;

// Way 2 (preferred): implement Runnable and pass it to a Thread.
// Advantage: you keep your single inheritance slot for your domain class,
// and the same Runnable can be reused / executed many times.

public class Ex implements Runnable {

    private final String label;

    public Ex(String label) { this.label = label; }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("[" + label + "] step " + i + " on " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        new Thread(new Ex("A"), "worker-A").start();
        new Thread(new Ex("B"), "worker-B").start();

        // Runnable is a functional interface -> can be a lambda
        new Thread(() -> System.out.println("[lambda] " + Thread.currentThread().getName())).start();
    }
}
