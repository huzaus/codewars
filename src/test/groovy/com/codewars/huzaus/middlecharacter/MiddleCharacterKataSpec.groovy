package com.codewars.huzaus.middlecharacter

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class MiddleCharacterKataSpec extends Specification {

    def "isOddLength should return '#result' for the '#word' word"() {
        expect:
        MiddleCharacterKata.isOddLength(word) == result
        where:
        word       || result
        "a"        || true
        "ab"       || false
        "abc"      || true
        "abcdefgh" || false
    }

    def "getMiddleCharacter should throw IllegalArgumentException when the input word is '#word'"() {
        when:
        MiddleCharacterKata.getMiddle(word)
        then:
        thrown(IllegalArgumentException)
        where:
        word << [null, "", 'A'.padLeft(1000)]
    }

    def "getMiddleCharacter('#word') should return '#result'"() {
        expect:
        MiddleCharacterKata.getMiddle(word) == result
        where:
        word   || result
        'A'    || 'A'
        'ABC'  || 'B'
        'AB'   || 'AB'
        'ABCD' || 'BC'

    }
}
