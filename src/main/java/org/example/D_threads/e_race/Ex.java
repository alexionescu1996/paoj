package org.example.D_threads.e_race;

// counter++ is NOT atomic (read, +1, write). Two threads can interleave
// and overwrite each other -> result smaller than 2*N.
// Fix with synchronized: method (lock on `this`) or block (lock on a
// dedicated object so we can narrow the critical section).

public class Ex {

    static class Unsafe {
        int value;
        void inc() { value++; }
    }

    static class SyncMethod {
        int value;
        synchronized void inc() { value++; } // lock on `this`
    }

    static class SyncBlock {
        int value;
        private final Object lock = new Object(); // dedicated lock, not `this`
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
