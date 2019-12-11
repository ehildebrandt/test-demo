package com.example.spock.demo_08_datadriven

class User {

    String name, gender

    Boolean isFemale() {
        gender == 'F'
    }
}
