package org.example.D_threads.c_join;

// join() = block the current thread until the target thread finishes.
// Typical when main starts parallel tasks and needs to wait for all of
// them before reading results.

public class Ex {

    static Runnable task(String name) {
        return () -> {
            try { Thread.sleep(500); } catch (InterruptedException e) { return; }
            System.out.println("done " + name);
        };
    }

    public static void main(String[] args) throws InterruptedException {
        long t0 = System.currentTimeMillis();

        Thread t1 = new Thread(task("A"));
        Thread t2 = new Thread(task("B"));
        Thread t3 = new Thread(task("C"));

        t1.start(); t2.start(); t3.start();

        // Without join(), main would print the time almost instantly
        // and exit before "done" lines appear.
        t1.join(); t2.join(); t3.join();

        System.out.println("total: " + (System.currentTimeMillis() - t0) + " ms"); // ~500, not 1500
    }
}
