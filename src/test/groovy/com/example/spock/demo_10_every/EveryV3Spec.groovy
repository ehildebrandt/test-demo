package com.example.spock.demo_10_every

import com.example.spock.ImmutableShip
import com.example.spock.MemoryShipStore
import spock.lang.Specification
import spock.lang.Subject

class EveryV3Spec extends Specification{

    @Subject(MemoryShipStore)
    def ships = new MemoryShipStore()

    def setup() {
        ships << ImmutableShip.builder().name("Gr'oth").allegiance("Klingon").build()
        ships << ImmutableShip.builder().name("Enterprise").allegiance("Federation").build()
        ships << ImmutableShip.builder().name("Constitution").allegiance("Federation").build()
        ships << ImmutableShip.builder().name("Constellation").allegiance("Federation").build()
        ships << ImmutableShip.builder().name("M'Char").allegiance("Klingon").build()
        ships << ImmutableShip.builder().name("Haakona").allegiance("Romulan").build()
    }

    def "should find ships by allegiance"() {
        when: "we query the ship store for ships by allegiance"
        def result = ships.findByAllegiance("Federation")

        then: "we expect that all ships in the result are of the given allegiance"
        result.allegiance.every {
            it == "Federation"
        }
    }

}
