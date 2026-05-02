package org.example.threads.synchronization;

// Demo race condition + sincronizare.
//
// Doua thread-uri incrementeaza acelasi contor de N ori.
// Rezultat asteptat: 2*N.  Rezultat real fara sincronizare: < 2*N,
// pentru ca "counter++" NU este atomic — sunt 3 operatii (citeste,
// incrementeaza, scrie) si doua thread-uri se pot suprapune.
//
// Reparam in doua moduri:
//   (a) metoda synchronized -> lock pe `this`
//   (b) bloc synchronized(lock) -> lock pe un obiect ales de noi
//
// Metoda este simpla, dar incuie tot obiectul. Blocul e mai precis:
// poti restrange sectiunea critica si poti folosi un lock dedicat.
public class CounterDemo {

    static class UnsafeCounter {
        int value = 0;
        void increment() { value++; }
    }

    static class SyncMethodCounter {
        int value = 0;
        // synchronized pe metoda = "incuie acest obiect (this) cat tine apelul"
        synchronized void increment() { value++; }
    }

    static class SyncBlockCounter {
        int value = 0;
        // Lock dedicat: nu folosim `this`, ca sa nu blocam alte metode.
        private final Object lock = new Object();

        void increment() {
            // Doar bucatica critica e protejata; restul metodei (daca ar fi)
            // ramane liber pentru alte thread-uri.
            synchronized (lock) {
                value++;
            }
        }
    }

    private static final int ITER = 100_000;

    public static void main(String[] args) throws InterruptedException {
        UnsafeCounter unsafe = new UnsafeCounter();
        runTwoThreads(unsafe::increment);
        System.out.println("Unsafe        : " + unsafe.value
                + "  (asteptam " + (2 * ITER) + ") -> de obicei mai mic");

        SyncMethodCounter sm = new SyncMethodCounter();
        runTwoThreads(sm::increment);
        System.out.println("Sync method   : " + sm.value + "  -> mereu corect");

        SyncBlockCounter sb = new SyncBlockCounter();
        runTwoThreads(sb::increment);
        System.out.println("Sync block    : " + sb.value + "  -> mereu corect");
    }

    private static void runTwoThreads(Runnable op) throws InterruptedException {
        Thread t1 = new Thread(() -> { for (int i = 0; i < ITER; i++) op.run(); });
        Thread t2 = new Thread(() -> { for (int i = 0; i < ITER; i++) op.run(); });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
