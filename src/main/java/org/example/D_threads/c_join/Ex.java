package org.example.D_threads.c_join;

// join() = block the current thread until the target thread finishes.
// Typical pattern: split work across N threads, start all, join all,
// then combine the partial results.
//
// Demo: sum a 1..N array in chunks, one thread per chunk, then add
// the partial sums. The expected total is N*(N+1)/2.

public class Ex {

    public static void main(String[] args) throws InterruptedException {
        int[] data = new int[1_000_000];
        for (int i = 0; i < data.length; i++) data[i] = i + 1;

        int chunks = 4;
        int chunkSize = data.length / chunks;
        Thread[] threads = new Thread[chunks];
        long[] partial = new long[chunks];

        for (int c = 0; c < chunks; c++) {
            int idx = c;                        // copy for the lambda (must be effectively final)
            int from = c * chunkSize;
            int to = from + chunkSize;
            threads[c] = new Thread(() -> {
                long sum = 0;
                for (int i = from; i < to; i++) sum += data[i];
                partial[idx] = sum;
                System.out.println("chunk " + idx + " sum = " + sum);
            });
            threads[c].start();
        }

        // Without join() main would read partial[] before threads finish
        // and the total below would be 0 (or partial).
        for (Thread t : threads) t.join();

        long total = 0;
        for (long p : partial) total += p;
        long expected = (long) data.length * (data.length + 1) / 2;
        System.out.println("total: " + total + " (expected " + expected + ")");
    }
}
