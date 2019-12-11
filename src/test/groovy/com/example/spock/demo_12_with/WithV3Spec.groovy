package com.example.spock.demo_12_with

import com.example.spock.ImmutableShip
import com.example.spock.Ship
import spock.lang.Specification

import java.time.Year

class WithV3Spec extends Specification {

    Ship ship = ImmutableShip.builder()
            .name("Enterprise")
            .allegiance("Federation")
            .enteredService(Year.of(2245))
            .build()

    def "should haven given attributes"() {
        expect:
        with(ship) {
            verifyAll {
                name() == "Enterprise"
                allegiance() == "Federation"
                enteredService() == Optional.of(Year.of(2245))
            }
        }
    }

}
