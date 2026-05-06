package org.example.D_threads.c_join;

// join() blocks the current thread until the target thread finishes.
// Common pattern: an array of tasks, start them all in a loop, then
// join them all in another loop, then continue once everything is done.

public class Ex {

    public static void main(String[] args) throws InterruptedException {
        String[] cities = {"Bucharest", "Cluj", "Iasi", "Timisoara", "Constanta"};
        Thread[] threads = new Thread[cities.length];

        long t0 = System.currentTimeMillis();

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i]; // local copy, effectively final for the lambda
            threads[i] = new Thread(() -> {
                try { Thread.sleep(500); } catch (InterruptedException e) { return; }
                System.out.println("done " + city);
            });
            threads[i].start();
        }

        // Without these joins, the line below would print ~0 ms,
        // because main would not wait for the workers.
        for (Thread t : threads) t.join();

        System.out.println("all " + cities.length + " done in " + (System.currentTimeMillis() - t0) + " ms");
    }
}
