package com.example.spock.demo_18_conditional

import spock.lang.IgnoreIf
import spock.lang.Requires
import spock.lang.Specification

class RequiresOperatingSystemSpec extends Specification {

    @Requires({ os.macOs })
    def "should run only on Mac OS"() {
        expect:
        System.getProperty("os.name").toLowerCase() == "mac os x"
    }

    @IgnoreIf({ os.windows })
    def "should run everywhere but on Windows"() {
        expect:
        true
    }

}
