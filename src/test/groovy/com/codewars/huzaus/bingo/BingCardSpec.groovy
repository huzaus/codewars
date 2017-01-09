package com.codewars.huzaus.bingo

import spock.lang.Specification
import spock.lang.Unroll

import static BingoCard.getCard
import static java.util.Collections.frequency

@Unroll
class BingCardSpec extends Specification {

    def "Should return twenty four strings"() {
        expect:
        getCard().length == 24
    }

    def "Should return different set of cards for each call"() {
        expect:
        getCard() != getCard()
    }

    def "#range cards should start from '#letter' "() {
        when:
        String[] cards = getCard()
        then:
        range.each({
            assert cards[it].startsWith(letter)
        })
        where:
        range    || letter
        (0..4)   || 'B'
        (5..9)   || 'I'
        (10..13) || 'N'
        (14..18) || 'G'
        (19..23) || 'O'
    }

    def "#range cards should start have number in '#expected' "() {
        when:
        String[] cards = getCard()
        then:
        range.each({
            assert expected.contains(cards[it].substring(1) as int)
        })
        where:
        range    || expected
        (0..4)   || (1..15)
        (5..9)   || (16..30)
        (10..13) || (31..45)
        (14..18) || (46..60)
        (19..23) || (61..75)
    }


    def "Should not have duplicate card"() {
        when:
        List cards = getCard() as List
        then:
        cards.every {
            frequency(cards, it) == 1
        }
        where:
        i << (1..10)
    }
}
