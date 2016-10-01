package com.codewars.huzaus;

class LongestConsecKata {

    public static String longestConsec(String[] array, int k) {
        if (isValidParameters(array, k)) {
            String result = getConsecString(array, 0, k);
            for (int i = 1; i < array.length - k + 1; i++) {
                String subResult = getConsecString(array, i, k);
                if (subResult.length() > result.length()) {
                    result = subResult;
                }
            }
            return result;
        }
        return "";
    }

    private static boolean isValidParameters(String[] array, int k) {
        return !(array.length == 0 || k > array.length || k <= 0);
    }

    private static String getConsecString(String[] array, int position, int k) {
        StringBuilder accumulator = new StringBuilder(array[position]);
        for (int i = position + 1; i < position +k; i++) {
            accumulator.append(array[i]);
        }
        return accumulator.toString();
    }
}
