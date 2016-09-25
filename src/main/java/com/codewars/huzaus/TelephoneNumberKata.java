package com.codewars.huzaus;

import static java.lang.String.format;
import static java.util.Arrays.stream;

public class TelephoneNumberKata {
    public static String createPhoneNumber(int... numbers) {
        if (numbers.length != 10) {
            throw new IllegalArgumentException();
        } else if (stream(numbers)
                .filter((i) -> i > 9)
                .findAny()
                .isPresent()) {
            throw new IllegalArgumentException();
        }

        return format("(%d%d%d) %d%d%d-%d%d%d%d", stream(numbers).boxed().toArray());
    }
}
