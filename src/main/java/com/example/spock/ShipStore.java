package com.example.spock;

import com.google.common.collect.ImmutableCollection;
import java.time.Year;

public interface ShipStore {

    void insert(Ship ship);

    ImmutableCollection<Ship> list();

    ImmutableCollection<Ship> findByAllegiance(String allegiance);

    ImmutableCollection<Ship> findByAllegianceNewestFirst(Object allegiance);

    ImmutableCollection<Ship> findByYearOfEnteredService(Year enteredService);

}
