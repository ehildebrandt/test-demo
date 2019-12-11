package com.example.spock.demo_01_basics

import spock.lang.Specification
import spock.lang.Subject

class BasicV6Spec extends Specification {

    @Subject
    def shipRepository = new ArrayList();

    def "should add ships to repository"() {
        expect:
        shipRepository.size() == 0

        when:
        shipRepository.add("Enterprise")

        then:
        shipRepository.size() == 1
    }

}
