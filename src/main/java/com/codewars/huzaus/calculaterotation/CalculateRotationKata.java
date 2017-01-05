package com.codewars.huzaus.calculaterotation;

public class CalculateRotationKata {
    static int shiftedDiff(String first, String second) {
        validate(first, second);
        if (first.length() == second.length()) {
            return second.concat(second).indexOf(first);
        }
        return -1;
    }

    private static void validate(String first, String second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
    }
}
