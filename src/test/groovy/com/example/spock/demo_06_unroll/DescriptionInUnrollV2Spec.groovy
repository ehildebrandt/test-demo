package com.example.spock.demo_06_unroll

import spock.lang.Specification
import spock.lang.Unroll

class DescriptionInUnrollV2Spec extends Specification {

    @Unroll
    def "the string '#string' is #description"() {
        expect:
        string.isInteger() == shouldBeInteger

        where:
        string | shouldBeInteger
        "ABC"  | false
        "123"  | true
        "1.2"  | false
        "1 2"  | false
        "12a"  | false

        description = shouldBeInteger ? "an integer" : "not an integer"
    }
}
