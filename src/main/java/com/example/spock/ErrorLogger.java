package com.example.spock;

import java.nio.channels.NotYetBoundException;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ErrorLogger {

    void handleExceptions(Function function, Object object) {
        try {
            function.apply(object);
        }catch (UnsupportedOperationException|NotYetBoundException e) {
            log.error(e.getMessage());
        } catch (Exception e) {
            log.error("Processing exception {}", e);
        }
    }

}
