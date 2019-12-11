package com.example.spock.demo_02_exception_handling

import com.example.spock.MemoryShipStore
import com.example.spock.ShipStore
import spock.lang.Specification

class ExceptionHandlingSpec extends Specification {

    ShipStore shipStore = new MemoryShipStore()

    def "should validate input values"() {
        when: "we search for ships by year of entered service with a null value"
        shipStore.findByYearOfEnteredService(null)

        then: "we expect an IllegalArgumentException to be thrown"
        IllegalArgumentException e = thrown()
        e.message == "enteredService must not be null."
    }

    // Note: It's possible to check that an exception was not thrown using notThrown() method.

}
