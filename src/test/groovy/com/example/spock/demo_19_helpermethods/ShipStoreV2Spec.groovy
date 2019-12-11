package com.example.spock.demo_19_helpermethods

import com.example.spock.MemoryShipStore
import com.example.spock.ShipStore
import spock.lang.Specification
import spock.lang.Subject

class ShipStoreV2Spec extends Specification implements ShipStoreHelpers {

    @Subject
    ShipStore ships = new MemoryShipStore()

    def "should read back ships after inserting them"() {
        given:
        withShip "Enterprise", "Federation"
        withShip "Haakona", "Romulan"

        expect:
        countByAllegiance("Federation") == 1
        countByAllegiance("Romulan") == 1
    }
}
