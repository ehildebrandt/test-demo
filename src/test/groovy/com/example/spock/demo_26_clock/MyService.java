package com.example.spock.demo_26_clock;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MyService {

    private final Clock clock;

    public String getDateAndTime() {
        return LocalDateTime.now(clock).format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
