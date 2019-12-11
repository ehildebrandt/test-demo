package com.example.spock.demo_28_whenthenwhenthen


import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
class StackSpec extends Specification {

    def "should use multiple when and then blocks"() {
        given:
        def stack = new Stack()

        when:
        stack.push "foo"

        then:
        stack.pop() == "foo"

        expect:
        stack.empty()

        when:
        stack.pop()

        then:
        thrown EmptyStackException
    }
}
