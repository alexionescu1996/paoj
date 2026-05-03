package org.example.threads.synchronization;

// counter++ NU e atomic (citeste, +1, scrie). Doua thread-uri se pot suprapune
// -> rezultat mai mic decat 2*N. Reparam cu synchronized.
public class CounterDemo {

    static class Unsafe {
        int value;
        void inc() { value++; }
    }

    static class SyncMethod {
        int value;
        synchronized void inc() { value++; } // lock pe `this`
    }

    static class SyncBlock {
        int value;
        private final Object lock = new Object(); // lock dedicat, nu `this`
        void inc() {
            synchronized (lock) { value++; }
        }
    }

    static final int N = 100_000;

    public static void main(String[] args) throws InterruptedException {
        var u = new Unsafe();      run(u::inc); System.out.println("unsafe: " + u.value);
        var m = new SyncMethod();  run(m::inc); System.out.println("method: " + m.value);
        var b = new SyncBlock();   run(b::inc); System.out.println("block:  " + b.value);
    }

    static void run(Runnable op) throws InterruptedException {
        Thread t1 = new Thread(() -> { for (int i = 0; i < N; i++) op.run(); });
        Thread t2 = new Thread(() -> { for (int i = 0; i < N; i++) op.run(); });
        t1.start(); t2.start();
        t1.join(); t2.join();
    }
}
