package com.example.spock.demo_19_helpermethods

import com.example.spock.ImmutableShip
import com.example.spock.ShipStore
import groovy.transform.CompileStatic

import java.time.Year

@CompileStatic
trait ShipStoreHelpers {
    abstract ShipStore getShips()

    void withShip(String name, String allegiance) {
        ships.insert ImmutableShip.builder().name(name).allegiance(allegiance).build();
    }

    void withShip(String name, String allegiance, Year enteredService) {
        ships.insert ImmutableShip.builder().name(name).allegiance(allegiance).enteredService(enteredService).build();
    }

    int countByAllegiance(String allegiance) {
        ships.findByAllegiance(allegiance).size()
    }
}
