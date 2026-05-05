package org.example.D_threads.d_interrupt;

// interrupt() does NOT force a thread to stop - it just raises a flag.
// The thread code must check the flag (isInterrupted) or catch
// InterruptedException from sleep/wait/join and respond to it.

public class Ex {

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("working " + (++i));
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // sleep clears the flag; re-set it
                }
            }
            System.out.println("clean shutdown after " + i + " iterations");
        });

        worker.start();
        Thread.sleep(800);
        worker.interrupt();
        worker.join();
    }
}
