package org.example.threads.basics;

// Varianta 2 (preferata): implementezi Runnable si il dai unui Thread.
// Avantaj: nu "consumi" mostenirea singulara a clasei tale.
public class RunnableDemo implements Runnable {

    private final String label;

    public RunnableDemo(String label) { this.label = label; }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("[" + label + "] pas " + i + " pe " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        new Thread(new RunnableDemo("A"), "worker-A").start();
        new Thread(new RunnableDemo("B"), "worker-B").start();

        // Runnable e interfata functionala -> lambda
        new Thread(() -> System.out.println("[lambda] " + Thread.currentThread().getName())).start();
    }
}
