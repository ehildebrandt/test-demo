package com.example.spock.demo_18_conditional

import groovy.transform.CompileStatic
import groovy.transform.Memoized

import static java.util.concurrent.TimeUnit.SECONDS

@CompileStatic
class Network {
    @Memoized
    static boolean isReachable(String url, long timeoutMillis = SECONDS.toMillis(1)) {
        try {
            def connection = url.toURL().openConnection()
            connection.connectTimeout = (int) timeoutMillis
            connection.connect()
            true
        } catch (IOException ignored) {
            false
        }
    }
}
