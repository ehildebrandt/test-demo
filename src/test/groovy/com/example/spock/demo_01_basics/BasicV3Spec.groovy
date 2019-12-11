package com.example.spock.demo_01_basics

import spock.lang.Specification
import spock.lang.Subject

class BasicV3Spec extends Specification {

    @Subject
    Stack stack = new Stack()

    def "should push to the stack"() {
        expect:
        stack.push("foo") == "foo"
    }

}
