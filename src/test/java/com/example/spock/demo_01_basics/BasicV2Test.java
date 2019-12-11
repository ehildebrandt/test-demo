package com.example.spock.demo_01_basics;

import java.util.Stack;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicV2Test {

    Stack<String> cut = new Stack<>();

    @Test
    public void should_push_to_the_stack() {
        // when:
        String result = cut.push("foo");

        // then:
        assertThat(result).isEqualTo("foo");
    }

}
