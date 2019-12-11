package com.example.spock.demo_20_mixins

trait UserInteractions {

    void loggedInAs(String user) {
        println "Logging in user '" + user + "'..."
        println "User '" + user + "'successfully logged in"
    }
}
