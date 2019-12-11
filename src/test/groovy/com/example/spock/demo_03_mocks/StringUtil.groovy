package com.example.spock.demo_03_mocks

import lombok.AllArgsConstructor

class StringUtil {

    private final Calculator calculator

    StringUtil(Calculator calculator) {
        this.calculator = calculator;
    }

    int size(final String[] s) {
        s.sum { calculator.calculateSize(it) }
    }
}