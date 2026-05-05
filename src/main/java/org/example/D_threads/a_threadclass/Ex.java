package org.example.D_threads.a_threadclass;

// Way 1 to start a thread: extend Thread, override run().
// Calling run() directly = same thread, sequential. start() = new OS thread.

public class Ex extends Thread {

    private final String label;

    public Ex(String label) { this.label = label; }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("[" + label + "] step " + i + " on " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        System.out.println("--- run() directly: on main, sequential ---");
        new Ex("A").run();
        new Ex("B").run();

        System.out.println("--- start(): two parallel threads ---");
        new Ex("A").start();
        new Ex("B").start();
    }
}
