package com.example.spock;

import com.google.common.collect.ImmutableCollection;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyService {

    private final ShipStore shipStore;

    public ImmutableCollection<Ship> getShips() {
        return this.shipStore.list();
    }

}
