package com.davidparry.spock

import com.davidparry.spock.validation.NegativeChecker
import com.davidparry.spock.validation.Validator
import spock.lang.Specification
import spock.lang.Unroll


class OddEvenCampImplSpec extends Specification {

    def setupSpec() {
        println('setupSpec')
    }

    def setup() {
        println('setup')
    }

    def cleanup() {
        println('cleanup')
    }

    def cleanupSpec() {
        println('cleanupSpec')
    }

    @Unroll
    def "for the given value #number return wil be #answer data driven"() {
        given:
        OddEvenCampImpl oddEvenCamp = new OddEvenCampImpl(Mock(Validator))
        when:
        int result = oddEvenCamp.check(number)

        then:
        result == answer

        where:
        number            | answer
        1                 | 0
        2                 | 1
        Integer.MAX_VALUE | 0
        18                | 1
        234121            | 0

    }

    def "for checking the behavior interactions with the Validator"() {
        given:
        Validator negativeChecker = Mock(Validator)
        OddEvenCampImpl oddEvenCamp = new OddEvenCampImpl(negativeChecker)

        when:
        oddEvenCamp.check(200)

        then:
        1 * negativeChecker.validate(3) >> { throw new NegativeNumberException("Negative number") }
        thrown(NegativeNumberException)


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



}