package com.example.spock;

import java.time.Year;
import java.util.Optional;
import org.immutables.value.Value.Immutable;

@Immutable
public interface Ship {

    String name();

    String allegiance();

    Optional<Year> enteredService();
}
