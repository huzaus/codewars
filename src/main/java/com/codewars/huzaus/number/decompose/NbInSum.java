package com.codewars.huzaus.number.decompose;

import static java.lang.Math.log;
import static java.lang.Math.pow;

import java.util.ArrayDeque;
import java.util.Deque;

public class NbInSum {

    public static long[][] decompose(long number) {
        validate(number);
        Deque<Long> list = nextNumber(number, 2);
        long remainder = list.removeLast();
        long[] powers = list.stream().mapToLong(i -> i).toArray();
        return new long[][]{powers, {remainder}};
    }

    private static Deque<Long> nextNumber(long number, long base) {
        if (number < pow(base, 2)) {
            return prepend(new ArrayDeque<>(), number);
        } else {
            long power = logarithm(number, base);
            return prepend(nextNumber(number - (long) pow(base, power), base + 1), power);
        }
    }

    private static long logarithm(long number, long base) {
        return (long) (log(number) / log(base));
    }


    private static void validate(long n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
    }

    private static <T> Deque<T> prepend(Deque<T> dequeue, T element) {
        dequeue.addFirst(element);
        return dequeue;
    }
}
