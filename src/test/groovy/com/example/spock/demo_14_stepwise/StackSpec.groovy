package com.example.spock.demo_14_stepwise

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise
import spock.lang.Subject

@Stepwise
class StackSpec extends Specification {

    @Shared
    @Subject
    Stack stack = new Stack()

    @Shared
    String value = "foo"

    def "should push to the stack"() {
        expect:
        stack.push(value) == value
    }

    def "stack should have content"() {
        expect:
        stack.peek() == value
    }

    def "should pop from the stack"() {
        expect:
        stack.pop() == value
    }

    def "the stack should be empty"() {
        expect:
        stack.empty()
    }

    def "trying to pop again raises an error"() {
        when:
        stack.pop()

        then:
        thrown EmptyStackException
    }
}
