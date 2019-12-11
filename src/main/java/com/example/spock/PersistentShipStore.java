package com.example.spock;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class PersistentShipStore implements ShipStore {

    private final List<Ship> ships = new ArrayList<>();

    @Override
    public void insert(Ship ship) {
        ships.add(ship);
    }

    @Override
    public ImmutableCollection<Ship> list() {
        return ImmutableSet.copyOf(ships);
    }

    @Override
    public ImmutableCollection<Ship> findByAllegiance(String allegiance) {
        return ships.stream()
            .filter(ship -> ship.allegiance().equals(allegiance))
            .collect(ImmutableSet.toImmutableSet());
    }

    @Override
    public ImmutableCollection<Ship> findByAllegianceNewestFirst(Object allegiance) {
        /*
         * NOTE: This implementation is deliberately faulty!
         */
        // ImmutableList.copyOf ships.sort { it.enteredService }
        return null;
    }

    @Override
    public ImmutableCollection<Ship> findByYearOfEnteredService(Year enteredService) {
        if(enteredService == null) {
            throw new IllegalArgumentException("enteredService must not be null.");
        }
        throw new RuntimeException("Not implemented.");
    }

    public void leftShift(Ship ship) {
        insert(ship);
    }
}
