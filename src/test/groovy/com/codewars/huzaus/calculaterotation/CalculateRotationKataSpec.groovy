package com.codewars.huzaus.calculaterotation

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class CalculateRotationKataSpec extends Specification {

    def "should throw IllegalArgumentException when: shiftedDiff(#first, #second)"() {
        when:
        CalculateRotationKata.shiftedDiff(first, second)
        then:
        thrown(IllegalArgumentException)
        where:
        first    | second
        null     | 'string'
        'string' | null
    }

    def "shiftedDiff('#first', '#second') == #result"() {
        expect:
        CalculateRotationKata.shiftedDiff(first, second) == result
        where:
        first     | second    || result
        'a'       | 'ab'      || -1
        'ab'      | 'ab'      || 0
        'ab'      | 'ba'      || 1
        'abc'     | 'bca'     || 2
        'bca'     | 'abc'     || 1
        'abcdefg' | 'gabcdef' || 1
        'gabcdef' | 'abcdefg' || 6
        'dog'     | 'god'     || -1
        'dog'     | 'Dog'     || -1
    }
}
