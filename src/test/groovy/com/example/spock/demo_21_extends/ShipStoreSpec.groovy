package com.example.spock.demo_21_extends

import com.example.spock.ImmutableShip
import com.example.spock.ShipStore
import spock.lang.Specification
import spock.lang.Subject

import java.time.Year

abstract class ShipStoreSpec<T extends ShipStore> extends Specification {

    @Subject
    T ships

    def "should insert a new ship"() {
        when:
        ships.insert(ImmutableShip.builder().name("Enterprise").allegiance("Federation").enteredService(Year.of(2245)).build())

        then:
        ships.list().size() == old(ships.list().size()) + 1
    }

    def "should find ships by allegiance"() {
        given:
        ships.insert(ImmutableShip.builder().name("Enterprise").allegiance("Federation").build())
        ships.insert(ImmutableShip.builder().name("Gr'oth").allegiance("Klingon").build())
        ships.insert(ImmutableShip.builder().name("Constellation").allegiance("Federation").build())

        when:
        def results = ships.findByAllegiance("Federation")

        then:
        results.size() == 2
        results.every { it.allegiance == "Federation" }
    }
}
