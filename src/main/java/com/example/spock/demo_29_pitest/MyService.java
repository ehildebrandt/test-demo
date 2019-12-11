package com.example.spock.demo_29_pitest;

public class MyService {

    public boolean isDangerous(int value) {
        if (value > 1000) {
            return true;
        } else {
            return false;
        }
    }

}
