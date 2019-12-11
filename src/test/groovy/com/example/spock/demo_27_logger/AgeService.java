package com.example.spock.demo_27_logger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AgeService {

    void offerAgeAdvice(int age) {
        if (age < 0) {
            log.error ("You cannot be {} years old!", age);
        } else if (age > 0 && age < 30) {
            log.info ("You are a young and vibrant :) Age {}", age);
            log.info ("Live life to the fullest");
        } else if (30 <= age) {
            log.warn ("It's all downhill from here, sorry. Age {}", age);
        }
    }

}
