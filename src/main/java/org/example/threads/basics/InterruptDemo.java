package org.example.threads.basics;

// Demo interrupt(): cum opresti politicos un thread care lucreaza mult.
//
// Reguli:
//  - Thread.interrupt() NU forteaza oprirea, doar ridica un "flag".
//  - Codul thread-ului trebuie SA VERIFICE acel flag (Thread.isInterrupted()
//    sau Thread.currentThread().isInterrupted()) sau sa prinda
//    InterruptedException la sleep/wait/join.
//  - Daca prinzi InterruptedException, flag-ul se reseteaza, deci de
//    obicei reapelezi Thread.currentThread().interrupt() ca sa il pastrezi.
//
// Domeniu: un "monitor" care scaneaza periodic ceva (logs, senzori, etc).
public class InterruptDemo {

    static class SensorMonitor implements Runnable {
        @Override
        public void run() {
            int reading = 0;
            // Verificam flag-ul la fiecare iteratie -> thread "cooperant".
            while (!Thread.currentThread().isInterrupted()) {
                reading++;
                System.out.println("  citire #" + reading
                        + " = " + (20 + Math.random() * 5) + " grade");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    // sleep() arunca InterruptedException si reseteaza flag-ul.
                    // Il setam la loc ca sa iasa bucla while.
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("  monitor: am primit interrupt, opresc curat. "
                    + "Total citiri: " + reading);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread monitor = new Thread(new SensorMonitor(), "sensor");
        monitor.start();

        // Lasam sa lucreze ~1 secunda, apoi cerem sa se opreasca.
        Thread.sleep(1000);
        System.out.println("main: trimit interrupt...");
        monitor.interrupt();

        // Asteptam confirmarea opririi.
        monitor.join();
        System.out.println("main: monitor s-a oprit, pot iesi.");
    }
}
