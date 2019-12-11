package com.example.spock.demo_23_documentation

import spock.lang.Issue
import spock.lang.Narrative
import spock.lang.See
import spock.lang.Specification
import spock.lang.Title

@Title("Allows to attach a natural-language name to a spec.")
@Narrative('''as a developer
              I want to die
              so I can end the pain''')
@Issue("https://github.com/spockframework/spock/issues/1049")
@See("https://tools.ietf.org/html/rfc7511")
class DocumentationAnotationsSpec extends Specification {


    def "If all sensors are inactive everything is ok" () {
        given: "the all fire sensors are off"

        when: "we ask the status of fire control"
        def status = "OFF"

        then: "no alarm or notification should be triggered"
        status == "OFF"
    }

    @Issue("https://github.com/spockframework/spock/issues/1049")
    def "If one sensor is active the alarm should sound as a precaution" () {
        given: "that only one fire sensor is active"

        when: "we ask the status of fire control"
        def status = "ERROR"

        then: "only the alarm shoud be triggered"
        status == "ALERT"
    }

    def "If more than one sensor are active then we have a fire" () {
        given: "that two fire sensors are active"

        when: "we ask the status of fire control"
        def status = "FIRE"

        then: "alarm is triggered and the fire department is notified"
        status == "FIRE"
    }

}
