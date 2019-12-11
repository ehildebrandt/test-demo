package com.example.spock.demo_11_failfast

import spock.lang.Specification

class FailFastV1Spec extends Specification {

    def "should identify numeric strings"() {
        expect:
        ["1", "-1", "1.1", "0xf", "0E+7"].every {
            it.isNumber()
        }
    }

}