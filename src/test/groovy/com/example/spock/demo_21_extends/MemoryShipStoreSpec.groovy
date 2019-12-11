package com.example.spock.demo_21_extends

import com.example.spock.MemoryShipStore

class MemoryShipStoreSpec extends ShipStoreSpec {

    def setup() {
        ships = new MemoryShipStore();
    }

}
