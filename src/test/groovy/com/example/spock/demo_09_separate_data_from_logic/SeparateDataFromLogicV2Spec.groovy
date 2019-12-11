package com.example.spock.demo_09_separate_data_from_logic

import io.reactivex.Observable
import spock.lang.Specification
import spock.lang.Subject

import java.util.function.Function

class SeparateDataFromLogicV2Spec extends Specification {

    @Subject
    def service = new StreamService()

    def "should pass data from stream to callback"() {
        given: "a callback function"
        def callback = Mock(Function)

        and: "a stub of StreamSource returning the given data"
        service.source = Stub(StreamSource) {
            connect() >> Observable.fromArray(*data)
        }

        when: "we read the steam"
        service.readStream(callback)

        then: "the callback function should be called once for every data value"
        data.each {
            1 * callback.apply(it)
        }

        where:
        data = ["foo", "bar", "baz"]
    }

}
