package com.example.spock.demo_21_extends

import com.example.spock.PersistentShipStore

class PersistentShipStoreSpec extends ShipStoreSpec {

    def setup() {
        ships = new PersistentShipStore()
    }

}
