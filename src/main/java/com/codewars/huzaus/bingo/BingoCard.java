package com.codewars.huzaus.bingo;

import static java.util.stream.Stream.concat;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BingoCard {

    public static String[] getCard() {
        return
            concat(bingoCards(bingoNumbers(5), "B", 0),
                concat(bingoCards(bingoNumbers(5), "I", 1),
                    concat(bingoCards(bingoNumbers(4), "N", 2),
                        concat(bingoCards(bingoNumbers(5), "G", 3),
                            bingoCards(bingoNumbers(5), "O", 4)))))
                .toArray(String[]::new);
    }

    private static IntStream bingoNumbers(int limit) {
        return ThreadLocalRandom.current()
                   .ints(1, 16)
                   .distinct()
                   .limit(limit);
    }

    private static Stream<String> bingoCards(IntStream bingoNumbers, String prefix, int multiplier) {
        return bingoNumbers.mapToObj(i -> prefix + (multiplier * 15 + i));
    }

}
