package com.example.spock.demo_08_datadriven

import com.xlson.groovycsv.CsvParser
import spock.lang.*

class ProviderSampleSpec extends Specification {

    @Shared
    def csv = '''number,name,gender,expected
            1,mrhaki,M,false
            2,Britt,F,true'''

    @Shared
    def data = new CsvParser().parse(csv)

    @Unroll("Gender #gender for #name is #description")
    def "check if user is female or male based on gender value"() {
        expect:
        new User(name: name, gender: gender).female == Boolean.valueOf(expected)

        where:
        [_, name, gender, expected] << data

        description = Boolean.valueOf(expected) ? 'female' : 'male'
    }

}
