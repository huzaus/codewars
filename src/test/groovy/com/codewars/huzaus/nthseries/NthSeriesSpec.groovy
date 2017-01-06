package com.codewars.huzaus.nthseries

import spock.lang.Specification
import spock.lang.Unroll

import static com.codewars.huzaus.nthseries.NthSeries.seriesSum

@Unroll
class NthSeriesSpec extends Specification {

    def "Should throw Illegal Argument exception when is '#value'"() {
        when:
        seriesSum value
        then:
        thrown IllegalArgumentException
        where:
        value << [0, -1, -100]
    }

    def "seriesSum #value == #result"() {
        expect:
        seriesSum(value) == result
        where:
        value || result
        1     || '1.00'
        2     || '1.25'
        5     || '1.57'
        15    || '1.94'
        33    || '2.21'
        43    || '2.30'
        71    || '2.46'
    }
}
