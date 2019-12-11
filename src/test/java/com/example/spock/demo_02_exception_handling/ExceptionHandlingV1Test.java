package com.example.spock.demo_02_exception_handling;

import com.example.spock.MemoryShipStore;
import com.example.spock.ShipStore;
import org.junit.Test;

public class ExceptionHandlingV1Test {

    ShipStore cut = new MemoryShipStore();

    @Test(expected = IllegalArgumentException.class)
    public void should_validate_input_values() {
        // when:
        cut.findByYearOfEnteredService(null);

        // then:
        // we expect an exception
    }

}
