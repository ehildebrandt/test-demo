package com.example.spock.demo_01_basics

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Subject

class BasicV5Spec extends Specification {

    @Subject
    Stack stack = new Stack() // <- instance fields are not shared!

    @Shared // <- expensive resources can be shared using @Shared annoations
    VeryExpensiveResource resource = new VeryExpensiveResource()

    def "should push to the stack"() {
        expect:
        stack.push("foo") == "foo"
    }

}
