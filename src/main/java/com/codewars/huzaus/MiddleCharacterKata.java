package com.codewars.huzaus;

public class MiddleCharacterKata {
    public static String getMiddle(String word) {
        validate(word);
        int middle = getMiddleIndex(word);
        return word.substring(middle - (isOddLength(word) ? 0 : 1), middle + 1);
    }

    private static void validate(String word) {
        if (word == null || word.length() == 0 || word.length() > 999) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isOddLength(String word) {
        return word.length() % 2 != 0;
    }

    private static int getMiddleIndex(String word) {
        return word.length() / 2;
    }
}
