package com.example.spock.demo_30_fixtures;

import org.immutables.value.Value.Immutable;

@Immutable
public interface Person {

    String name();
    Address address();
}
