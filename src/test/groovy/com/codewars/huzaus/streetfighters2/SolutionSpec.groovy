package com.codewars.huzaus.streetfighters2

import spock.lang.Specification
import spock.lang.Unroll

import static Solution.streetFighterSelection

@Unroll
class SolutionSpec extends Specification {

    def "Should throw IllegalArgumentException when streetFighterSelection(#fighters, #position, #moves)"() {
        when:
        streetFighterSelection fighters as String[][], position as int[], moves as String[]
        then:
        thrown IllegalArgumentException
        where:
        fighters  | position  | moves
        null      | [0, 0]    | []
        [['Ryu']] | null      | []
        [['Ryu']] | [0, 0]    | null
        [[]]      | [0, 0]    | []
        [['Ryu']] | [0]       | []
        [['Ryu']] | [0, 0, 0] | []
        [['Ryu']] | [1, 0]    | []
        [['Ryu']] | [0, 1]    | []
    }

    def "Should return #result when streetFighterSelection(#fighters, #position, #moves)"() {
        expect:
        streetFighterSelection(fighters as String[][], position as int[], moves as String[]) == result
        where:
        fighters                           | position | moves                       || result
        [['Ryu']]                          | [0, 0]   | []                          || []
        [['Ryu']]                          | [0, 0]   | ['right']                   || ['Ryu']
        [['Ryu', 'E.Honda']]               | [0, 0]   | ['right', 'right']          || ['E.Honda', 'Ryu']
        [['Ryu', 'E.Honda']]               | [0, 0]   | ['right', 'right', 'right'] || ['E.Honda', 'Ryu', 'E.Honda']
        [['Ryu']]                          | [0, 0]   | ['up']                      || ['Ryu']
        [['Ryu'], ['E.Honda']]             | [0, 0]   | ['up', 'up']                || ['Ryu', 'Ryu']
        [['Ryu'], ['E.Honda']]             | [0, 1]   | ['up', 'up']                || ['Ryu', 'Ryu']
        [['Ryu'], ['E.Honda'], ['Blanka']] | [0, 2]   | ['up', 'up', 'up']          || ['E.Honda', 'Ryu', 'Ryu']
        [['Ryu']]                          | [0, 0]   | ['down']                    || ['Ryu']
        [['Ryu'], ['E.Honda']]             | [0, 1]   | ['down', 'down']            || ['E.Honda', 'E.Honda']
        [['Ryu'], ['E.Honda']]             | [0, 0]   | ['down', 'down']            || ['E.Honda', 'E.Honda']
        [['Ryu'], ['E.Honda'], ['Blanka']] | [0, 0]   | ['down', 'down', 'down']    || ['E.Honda', 'Blanka', 'Blanka']
    }

    def "Should throw #exception for unknown '#operation' operation"() {
        when:
        streetFighterSelection(['Ryu'] as String[][], [0, 0] as int[], [operation] as String[])
        then:
        thrown(exception)
        where:
        operation  || exception
        null       || NullPointerException
        'diagonal' || IllegalArgumentException
        'unknown'  || IllegalArgumentException

    }

    def "streetFighterSelection(#fighters, [0, 0], #operation) == #result" () {
        expect:
        streetFighterSelection(fighters as String[][], [0, 0] as int[], operation as String[]) == result
        where:
        fighters = [
                ["Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"],
                ["Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"]
        ]
        operation = ["up", "left", "down", "right", "up", "left", "down", "right"]
        result = ["Ryu", "Vega", "M.Bison", "Ken", "Ryu", "Vega", "M.Bison", "Ken"]


    }


}
