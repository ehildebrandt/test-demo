package com.example.spock.demo_29_pitest

import spock.lang.Specification
import spock.lang.Subject

class MyServiceSpec extends Specification {

    @Subject
    MyService myService = new MyService()

    def "should report dangerous"() {
        when:
        def result = myService.isDangerous(value)

        then:
        result == expectedResult

        where:
        value | expectedResult
        1000   | false
        2000  | true
    }

}
