package com.example.spock.demo_13_old

import spock.lang.Specification
import spock.lang.Subject

class OldV3Spec extends Specification {

    @Subject
    Stack stack = new Stack()

    def "size increases when we add items to a stack"() {
        when:
        stack.push "foo"

        then:
        stack.size() == old(stack.size()) + 1
    }
}
