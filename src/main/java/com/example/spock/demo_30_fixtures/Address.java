package com.example.spock.demo_30_fixtures;

import java.util.Optional;
import org.immutables.value.Value.Immutable;

@Immutable
public interface Address {

    String line1();
    Optional<String> line2();

}
