package com.example.spock.demo_09_separate_data_from_logic

import spock.lang.Specification
import spock.lang.Subject

import java.util.function.Function
import io.reactivex.Observable;

class SeparateDataFromLogicV1Spec extends Specification {

    @Subject
    def service = new StreamService()

    def "should pass data from stream to callback"() {
        given: "a callback function"
        def callback = Mock(Function)

        and: "a stub of StreamSource returning the given data"
        service.source = Stub(StreamSource) {
            connect() >> Observable.fromArray("foo", "bar", "baz")
        }

        when: "we read the steam"
        service.readStream(callback)

        then: "the callback function should be called once for every data value"
        1 * callback.apply("foo")
        1 * callback.apply("bar")
        1 * callback.apply("baz")
    }

}
