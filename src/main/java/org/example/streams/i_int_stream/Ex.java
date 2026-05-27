package org.example.streams.i_int_stream;

import java.util.stream.IntStream;

public class Ex {
    public static void main(String[] args) {

        // IntStream: primitive int stream, exposes sum/average/min/max
        int sum = IntStream.rangeClosed(1, 10).sum();

        System.out.println("sum 1..10 = " + sum);
    }
}
