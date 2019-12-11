package com.example.spock.demo_02_exception_handling;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.fail;

import com.example.spock.MemoryShipStore;
import com.example.spock.ShipStore;
import org.junit.Test;

public class ExceptionHandlingV2Test {

    ShipStore cut = new MemoryShipStore();

    @Test
    public void should_validate_input_values() {
        try {
            cut.findByYearOfEnteredService(null);
            fail("exception not thrown");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
            assertThat(e.getMessage()).isEqualTo("enteredService must not be null.");
        }
    }

}
