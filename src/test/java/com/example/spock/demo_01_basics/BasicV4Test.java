package com.example.spock.demo_01_basics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class BasicV4Test {

    @Before
    public void setup() {
        // run before every feature method
    }

    @After
    public void cleanup() {
        // run after every feature method
    }

    @BeforeClass
    public void setupSpec() {
        // run before first feature method
    }

    @AfterClass
    public void cleanupSpec() {
        // run after last feature method
    }

}
