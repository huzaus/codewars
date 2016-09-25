package com.codewars.huzaus

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class TelephoneNumberKataSpec extends Specification {

    def "Should throw '#exception' when input is '#input'"() {
        when:
        TelephoneNumberKata.createPhoneNumber(input)
        then:
        thrown(exception)
        where:
        input                                      || exception
        null                                       || NullPointerException
        [] as int[]                                || IllegalArgumentException
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1] as int[] || IllegalArgumentException
        [1, 2, 3, 4, 5, 6, 7, 8, 9] as int[]       || IllegalArgumentException
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] as int[]   || IllegalArgumentException
    }

    def "Should transform '#input' -> '#result'"() {
        expect:
        TelephoneNumberKata.createPhoneNumber(input) == result
        where:
        input                                   || result
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 0] as int[] || '(123) 456-7890'
        [5, 0, 3, 5, 6, 2, 4, 4, 4, 6] as int[] || '(503) 562-4446'
    }
}
