package com.davidparry.spock

import spock.lang.Specification

class NegativeNumberExceptionSpec extends Specification {

    def "GetMessage from Constructor"() {
        expect:
        new NegativeNumberException("TEST").getMessage() == "TEST"
    }

}
