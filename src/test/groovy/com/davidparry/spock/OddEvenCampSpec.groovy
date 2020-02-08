package com.davidparry.spock

import com.davidparry.spock.validation.NegativeChecker
import com.davidparry.spock.validation.Validator
import spock.lang.Specification
import spock.lang.Unroll

class OddEvenCampSpec extends Specification {
    def setupSpec() {}

    def setup() {}

    @Unroll
    def "for the given value #number return will be #answer data driven"() {
        given:
        OddEvenCampImpl oddEvenCamp = new OddEvenCampImpl(Mock(Validator))

        when:
        int result = oddEvenCamp.check(number)

        then:
        result == answer

        where:
        number            | answer
        1                 | 1
        2                 | 0
        Integer.MAX_VALUE | 1
        18                | 0
        234121            | 1
    }

    def "for negative number or zero exception thrown"() {
        given:
        NegativeChecker negativeChecker = new NegativeChecker()
        OddEvenCampImpl oddEvenCamp = new OddEvenCampImpl(negativeChecker)

        when:
        oddEvenCamp.check(-1)

        then:
        thrown(NegativeNumberException)

    }

    def "for checking the behavior interactions with the Validator"() {
        given:
        Validator negativeChecker = Mock(Validator)
        OddEvenCampImpl oddEvenCamp = new OddEvenCampImpl(negativeChecker)

        when:
        oddEvenCamp.check(0)

        then:
        1 * negativeChecker.validate(0) >> { throw new NegativeNumberException("Negative number") }
        thrown(NegativeNumberException)

    }


    def cleanup() {}

    def cleanupSpec() {}
}



