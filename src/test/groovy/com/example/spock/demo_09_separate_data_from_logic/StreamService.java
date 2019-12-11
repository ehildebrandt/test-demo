package com.example.spock.demo_09_separate_data_from_logic;

import java.util.function.Function;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StreamService {

    StreamSource source;

    void readStream(Function callback) {
        source.connect().subscribe(it -> callback.apply(it));
    }

}
