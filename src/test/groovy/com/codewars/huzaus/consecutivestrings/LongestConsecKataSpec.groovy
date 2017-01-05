package com.codewars.huzaus.consecutivestrings

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class LongestConsecKataSpec extends Specification {

    def "should return empty line when '#array' and '#k'"() {
        expect:
        LongestConsecKata.longestConsec(array as String[], k) == ""
        where:
        array   | k
        []      | 1
        ['one'] | 2
        ['one'] | 0
        ['one'] | -1
    }

    def "should calculate '#result' for the '#array' '#position' '#k' "() {
        expect:
        LongestConsecKata.getConsecString(array as String[], position, k) == result
        where:
        array                   | position | k || result
        ['one']                 | 0        | 1 || 'one'
        ['one', 'two']          | 0        | 2 || 'onetwo'
        ['one', 'two', 'three'] | 0        | 3 || 'onetwothree'
        ['one', 'two', 'three'] | 1        | 2 || 'twothree'
    }

    def "should return '#result' for the '#array' '#k'"() {
        expect:
        LongestConsecKata.longestConsec(array as String[], k) == result
        where:
        array                          | k || result
        ['one']                        | 1 || 'one'
        ['one', 'two']                 | 2 || 'onetwo'
        ['one', 'two', 'three']        | 2 || 'twothree'
        ['one', 'two', 'three', 'one'] | 2 || 'twothree'
        ['one', 'two', 'three', 'one'] | 3 || 'onetwothree'

    }
}
