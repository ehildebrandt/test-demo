package com.example.spock.demo_18_conditional

import spock.lang.IgnoreIf
import spock.lang.Specification

import static java.net.HttpURLConnection.HTTP_OK

class RequiresNetworkSpec extends Specification {

    @IgnoreIf({ !Network.isReachable("http://httpbin.org/") })
    def "should connect to httpbin.org via http"() {
        given: "we have a http connection to httpbin.org"
        HttpURLConnection connection = "http://httpbin.org/".toURL().openConnection()

        when: "we connect"
        connection.connect()

        then: "the connection response code should be OK"
        connection.responseCode == HTTP_OK
    }
}
