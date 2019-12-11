package com.example.spock.demo_15_system_properties

import spock.lang.Specification
import spock.lang.Stepwise
import spock.util.environment.RestoreSystemProperties

@Stepwise
class SystemPropertiesSpec extends Specification {

    @RestoreSystemProperties
    def "first method adds a Java system property"() {
        setup:
        System.properties['spockAdded'] = 'Spock is gr8'

        expect:
        System.properties['spockAdded'] == 'Spock is gr8'
    }

    def "second method has no access to the new property"() {
        expect:
        !System.getProperty('spockAdded')
    }

}
