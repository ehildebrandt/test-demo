package com.example.spock.demo_05_where

import spock.lang.Unroll

class WhereV2Spec extends spock.lang.Specification {

    String REGEX = /[-+]?\d+(\.\d+)?([eE][-+]?\d+)?/

    @Unroll
    def 'matching example #example for case "#description" should yield #isMatchExpected'() {
        expect:
        (example ==~ REGEX) == isMatchExpected

        where:
        description                                                 | example        || isMatchExpected
        "empty string"                                              | ""             || false
        "single non-digit"                                          | "a"            || false
        "single digit"                                              | "1"            || true
        "integer"                                                   | "123"          || true
        "integer, negative sign"                                    | "-123"         || true
        "integer, positive sign"                                    | "+123"         || true
        "float"                                                     | "123.12"       || true
        "float with exponent extension but no value   asdfasdfasdf" | "123.12e"      || false
        "float with exponent"                                       | "123.12e12"    || true
        "float with uppercase exponent"                             | "123.12E12"    || true
        "float with non-integer exponent"                           | "123.12e12.12" || false
        "float with exponent, positive sign"                        | "123.12e+12"   || true
        "float with exponent, negative sign"                        | "123.12e-12"   || true
    }

    // Note 1: IntelliJ can automatically format the table.
    // Note 2: demonstrate diagnostics
}
