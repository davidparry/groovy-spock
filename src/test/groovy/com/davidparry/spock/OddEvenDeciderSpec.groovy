package com.davidparry.spock

import com.davidparry.spock.validation.NegativeChecker
import com.davidparry.spock.validation.Validator
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class OddEvenDeciderSpec extends Specification {

    @Shared
    int count


    def setupSpec() {
        println("setup")
    }

    def cleanupSpec() {
        println("cleanup")
    }


    def setup() {
        count++
    }

    def cleanup() {
        println("Count " + count)
    }

    def "checkme out test "() {
        given: "We are going to show private methods"

        when:
        OddEvenCamp oddEvenCamp = new OddEvenDecider(Mock(Validator))

        then:
        int result = oddEvenCamp.checkmeout("1")
        result == 1
    }

    def "what is the value"() {
        expect:
        new OddEvenDecider(Mock(Validator)).somemorework(2) == 3
    }

    def "for "() {
        given:
        Validator<Integer> integerValidator = Mock(Validator)
        OddEvenCamp oddEvenCamp = new OddEvenDecider(integerValidator)
        when:
        oddEvenCamp.check(-1)

        then:
        thrown(NegativeNumberException)
        1 * integerValidator.validate(-1) >> { throw new NegativeNumberException("ouch") }



    }

    def "test for an invalid  "() {
        given:
        OddEvenCamp oddEvenDecider = new OddEvenDecider()
        when:
        oddEvenDecider.checkmeout("yu")

        then:
        thrown(NumberFormatException)
    }


    @Unroll
    def "check for runtime when #value "() {
        given:
        Validator validator = new NegativeChecker()
        OddEvenCamp oddEvenCamp = new OddEvenDecider(validator)
        when:
        oddEvenCamp.check(value)
        then:
        thrown(NegativeNumberException)

        where:
        value << [0, -1, -2]

    }

    def "for ensure no execption thrown"() {

        when:
        new OddEvenDecider(Mock(Validator))

        then:
        noExceptionThrown()


    }


    @Unroll
    def "test if #value is #answer"() {
        given:
        Validator validator = Mock()
        OddEvenCamp oddEvenCamp = new OddEvenDecider(validator)

        when:
        int result = oddEvenCamp.check(value)

        then:
        co * validator.validate(value)
        result == answer

        where:
        value | answer | co
        1     | 1      | 1
        2     | 0      | 1
        3     | 1      | 1

    }


}
