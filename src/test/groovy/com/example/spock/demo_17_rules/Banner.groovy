package com.example.spock.demo_17_rules

class Banner {

    String message

    void print() {
        println ' Message '.center(15, '*')
        println message.center(15)
    }

}
