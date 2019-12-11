package com.example.spock.demo_05_where

import spock.lang.Specification

class WhereV1Spec extends Specification {

    def "should calculate the length of name"() {
        expect:
        name.size() == length

        where:
        name     | length
        "Spock"  | 5
        "Kirk"   | 4
        "Scotty" | 6
    }

}
