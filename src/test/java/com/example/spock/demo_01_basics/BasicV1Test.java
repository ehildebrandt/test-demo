package com.example.spock.demo_01_basics;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;
import org.junit.Test;

public class BasicV1Test {

    @Test
    public void testPopStack() {
        Stack<String> stack = new Stack<>();
        String result = stack.push("foo");
        assertThat(result).isEqualTo("foo");
    }

}
