package com.example.spock.demo_17_rules

import org.junit.Rule
import org.springframework.boot.test.system.OutputCaptureRule
import spock.lang.Specification

class RuleSpec extends Specification {

    @Rule
    OutputCaptureRule capture = new OutputCaptureRule()

    def "capture output print method"() {
        when:
        print 'Groovy rocks'

        then:
        capture.toString() == 'Groovy rocks'
    }

    def "banner text must contain given messagen and fixed header"() {
        given:
        final Banner banner = new Banner(message: 'Spock is gr8!')

        when:
        banner.print()

        then:
        final List lines = capture.toString().tokenize(System.properties['line.separator'])
        lines.first() == '*** Message ***'
        lines.last()  == ' Spock is gr8! '
    }
}
