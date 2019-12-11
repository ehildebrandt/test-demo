package com.example.spock.demo_03_mocks

import spock.lang.Specification
import spock.lang.Subject

class MockV2Spec extends Specification {

    def calculator = Mock(Calculator)

    @Subject
    def util = new StringUtil(calculator)

    def "should calculate sizes of string values"() {
        when:
        def total = util.size('one', 'two', 'three', 'four', 'five')

        then:
        5 * calculator.calculateSize(_) >>> [1,3,4,4,4]

        and:
        total == 1 + 3 + 4 + 4 + 4
    }

}
