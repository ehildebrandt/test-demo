package com.example.spock.demo_30_fixtures

import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader
import spock.lang.Specification

class FixtureSpec extends Specification {

    def setup() {
        FixtureFactoryLoader.loadTemplates("com.example.spock.demo_30_fixtures")
    }

    def "should generate a person from a fixture"() {
        given:
        List<Person> persons = Fixture.from(ImmutablePerson).gimme(2,"invalid")

        when:
        println persons

        then:
        persons.size() == 2
    }

}
