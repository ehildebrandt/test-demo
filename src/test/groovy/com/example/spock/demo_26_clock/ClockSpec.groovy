package com.example.spock.demo_26_clock

import spock.lang.Specification

import java.time.Clock
import java.time.Instant
import java.time.ZoneId

class ClockSpec extends Specification {

    Clock fixedClock = Clock.fixed(Instant.parse("2011-12-03T10:15:30+01:00"), ZoneId.systemDefault())

    MyService myService = new MyService(fixedClock)

    def "should return current date and time as ISO string"() {
        expect:
        myService.getDateAndTime() == "2011-12-03T10:15:30"
    }
}
