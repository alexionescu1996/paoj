package org.example.threads.basics;

// join() = blocheaza firul curent pana cand thread-ul referit termina.
// Tipic cand main porneste task-uri paralele si vrea sa citeasca rezultatul DUPA ce toate au gata.
public class JoinDemo {

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

        // fara join(), ar afisa timpul aproape instant si ar iesi inainte de "done"
        t1.join(); t2.join(); t3.join();

        System.out.println("total: " + (System.currentTimeMillis() - t0) + " ms"); // ~500, nu 1500
    }
}
