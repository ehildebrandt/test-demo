package com.example.spock.demo_04_diagnostics;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Test;

public class DiagnosticsTest {

    @Test
    public void shouldCalculate() {
        assertThat(4 * 15 - 24 / 3).isEqualTo(2 * 30 - 9);
    }

}
