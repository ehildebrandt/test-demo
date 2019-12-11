package com.example.spock.demo_03_mocks

import spock.lang.Specification
import spock.lang.Subject

class MockV1Spec extends Specification {

    Calculator calculator = Mock()

    @Subject
    def util = new StringUtil(calculator)

    def "should calculate sizes of string values"() {
        when:
        def total = util.size('some string')

        then:
        1 * calculator.calculateSize(_) >> 4

        and:
        total == 4
    }

    // Wildcard for number of excecutions:
    //  3 * list.size()           // 3 times
    // (3.._) * list.size()       // 3 or more
    // (_..3) * list.size()       // up to 3

    // All sorts of constrains:
    // pojo./*.set.*/(_)          // any set method with one arg
    // pojo.method(_, _)          // method with two args of any type
    // pojo.method(*_)            // method with any number and kind of args
    // pojo.method(_ as String)   // method with one String arg
}
