package com.codewars.huzaus.number.decompose

import spock.lang.Specification
import spock.lang.Unroll

import static com.codewars.huzaus.number.decompose.NbInSum.decompose

@Unroll
class NbInSumSpec extends Specification {

    def "should throw IllegalArgumentException when input parameter is less than zero"() {
        when:
        decompose(-1)
        then:
        thrown(IllegalArgumentException)
    }

    def "decompose('#value') == #result"() {
        expect:
        decompose(value) == result as long[][]
        where:
        value   || result
        0       || [[], [0]]
        1       || [[], [1]]
        2       || [[], [2]]
        3       || [[], [3]]
        4       || [[2], [0]]
        6       || [[2], [2]]
        8       || [[3], [0]]
        9       || [[3], [1]]
        25      || [[4, 2], [0]]
        45      || [[5, 2], [4]]
        8330475 || [[22, 13, 10, 8, 7, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2], 0]
    }

}
