package com.example.spock.demo_11_failfast

import spock.lang.Specification
import spock.lang.Unroll

class FailFastV2Spec extends Specification {

    @Unroll("'#n' is numeric")
    def "should identify numeric strings"() {
        expect:
        n.isNumber()

        where:
        n << ["1", "-1", "1.1", "0xf", "0E+7"]
    }

}
