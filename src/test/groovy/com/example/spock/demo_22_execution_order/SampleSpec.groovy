package com.example.spock.demo_22_execution_order

import spock.lang.Specification
import spock.lang.Subject

class SampleSpec extends Specification {

    @Subject
    private Sample sample = new Sample()

    def "spec1 - slowly should return name property value"() {
        given:
        sample.name = testValue

        expect:
        sample.slowly() == testValue

        where:
        testValue = 'Spock rules'
    }

    def "spec2 - check name property"() {
        given:
        sample.name = testValue

        expect:
        sample.name == testValue

        where:
        testValue = 'Spock is gr8'
    }

    def "spec3 - purposely fail test at random"() {
        given:
        sample.name = testValues[randomIndex]

        expect:
        sample.name == testValues[0]

        where:
        testValues = ['Spock rules', 'Spock is gr8']
        randomIndex = new Random().nextInt(testValues.size())
    }

    def "spec4 - purposely fail test slowly"() {
        given:
        sample.name = 'Spock is gr8'

        expect:
        sample.slowly() == 'Spock rules'
    }

    def "spec5 - purposely fail test"() {
        given:
        sample.name = 'Spock rules'

        expect:
        sample.name == 'Spock is gr8'
    }
}

class Sample {
    String name

    String slowly() {
        Thread.sleep(2000)
        name
    }
}
