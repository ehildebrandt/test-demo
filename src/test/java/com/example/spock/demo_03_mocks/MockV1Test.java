package com.example.spock.demo_03_mocks;

import static org.assertj.core.api.Assertions.assertThat;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.Before;
import org.junit.Test;

public class MockV1Test {

    // IMPORTANT:
    // Configure the test execution JVM to start with:
    // -javaagent:${settings.localRepository}/org/jmockit/jmockit/${jmockit.version}/jmockit-${jmockit.version}.jar

    @Mocked
    Calculator calculator;

    StringUtil util;

    @Before
    public void setup() {
        util = new StringUtil(calculator);
    }

    @Test
    public void should_calculate_sizes_of_string_values() {
        new Expectations() {{
            calculator.calculateSize(anyString); result = 4;
        }};

        // when:
        int total = util.size(new String[]{"one"});

        // then:
        assertThat(total).isEqualTo(4);
    }

}
