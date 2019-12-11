package com.example.spock.demo_19_helpermethods

import com.example.spock.ImmutableShip
import com.example.spock.MemoryShipStore
import com.example.spock.ShipStore
import spock.lang.Specification
import spock.lang.Subject

class ShipStoreV1Spec extends Specification {

    @Subject
    ShipStore ships = new MemoryShipStore()

    def "should read back ships after inserting them"() {
        given:
        ships.insert(ImmutableShip.builder().name("Enterprise").allegiance("Federation").build())
        ships.insert(ImmutableShip.builder().name("Haakona").allegiance("Romulan").build())

        expect:
        ships.findByAllegiance("Federation").size() == 1
        ships.findByAllegiance("Romulan").size() == 1
    }

}
