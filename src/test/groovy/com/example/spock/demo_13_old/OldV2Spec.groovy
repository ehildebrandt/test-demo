package com.example.spock.demo_13_old

import spock.lang.Specification
import spock.lang.Subject

class OldV2Spec extends Specification {

    @Subject
    Stack stack = new Stack()

    def "should increase size when we add items to a stack"() {
        given:
        def oldSize = stack.size()

        when:
        stack.push "foo"

        then:
        stack.size() == oldSize + 1
    }

}
