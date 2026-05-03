package org.example.threads.basics;

// Varianta 1: extinzi Thread, suprascrii run().
// run() direct = secvential pe main. start() = thread nou.
public class ThreadSubclassDemo extends Thread {

    private final String label;

    public ThreadSubclassDemo(String label) { this.label = label; }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("[" + label + "] pas " + i + " pe " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        System.out.println("--- run() direct: pe main, secvential ---");
        new ThreadSubclassDemo("A").run();
        new ThreadSubclassDemo("B").run();

        System.out.println("--- start(): paralel ---");
        new ThreadSubclassDemo("A").start();
        new ThreadSubclassDemo("B").start();
    }
}
