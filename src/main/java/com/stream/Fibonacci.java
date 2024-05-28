package com.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
        Stream<Long> na = Stream.generate(new FibonacciSupplier());

        long c = na.limit(100).map(n -> n * n).filter(n -> n < 100).reduce(0L, (acc, n) -> acc + n);
        System.out.println(c);
    }
}

class FibonacciSupplier implements Supplier<Long> {
    long n1 = 1;
    long n2 = 1;

    long time = 0;

    public Long get() {
        if (time == 0) {
            time++;
            return n1;
        }

        if (time == 1) {
            time++;
            return n2;
        }

        long res = n1 + n2;

        n1 = n2;
        n2 = res;
        time++;

        return res;
    }
}
