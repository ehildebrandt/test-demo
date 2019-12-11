package com.example.spock.demo_01_basics

import spock.lang.Specification

class BasicV2Spec extends Specification {

    def "should push to the stack"() {
        given:  // or setup:
        def stack = new Stack()

        when: "we do something"
        stack.push( "foo")

        then:
        stack.pop() == "foo"

        // cleanup:
    }

    // Note: It's possible to write descriptive text for every block.

}
