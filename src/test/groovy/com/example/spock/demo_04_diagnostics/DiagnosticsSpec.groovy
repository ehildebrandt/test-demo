package com.example.spock.demo_04_diagnostics

import spock.lang.Specification

class DiagnosticsSpec extends Specification {

    def "should calculate"() {
        expect:
        4 * 15 - 24 /3 == 2 * 30 - 9
    }

}
