package com.example.spock.demo_06_unroll

import spock.lang.Specification
import spock.lang.Unroll

class DescriptionInUnrollV1Spec extends Specification {

    @Unroll
    def "should tell if the string '#string' is an integer or not"() {
        expect:
        string.isInteger() == shouldBeInteger

        where:
        string | shouldBeInteger
        "ABC"  | false
        "123"  | true
        "1.2"  | false
        "1 2"  | false
        "1a2"  | false
    }

}
