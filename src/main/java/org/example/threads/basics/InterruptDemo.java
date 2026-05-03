package org.example.threads.basics;

// interrupt() NU forteaza oprirea, doar ridica un flag.
// Codul thread-ului trebuie sa il verifice (isInterrupted) sau sa prinda InterruptedException.
public class InterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("lucrez " + (++i));
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // sleep reseteaza flag-ul; il punem la loc
                }
            }
            System.out.println("opresc curat dupa " + i + " iteratii");
        });

        worker.start();
        Thread.sleep(800);
        worker.interrupt();
        worker.join();
    }
}
