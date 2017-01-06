package com.codewars.huzaus.nthseries;


import static java.util.stream.DoubleStream.iterate;

public class NthSeries {

    public static String seriesSum(int n) {
        validate(n);

        return String.format("%.2f",
            iterate(1, i -> i + 3)
                .limit(n)
                .map(i -> 1 / i)
                .sum()
        );
    }

    private static void validate(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
    }
}
