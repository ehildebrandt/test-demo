package com.example.spock.demo_27_logger

import spock.lang.Specification
import spock.lang.Subject
import uk.org.lidalia.slf4jext.Level
import uk.org.lidalia.slf4jtest.TestLogger
import uk.org.lidalia.slf4jtest.TestLoggerFactory

class LoggerSpec extends Specification {

    @Subject
    AgeService ageService = new AgeService()

    def "should log age advice"() {
        given:
        TestLogger logger = TestLoggerFactory.getTestLogger(AgeService.class)

        when:
        ageService.offerAgeAdvice(-1)

        then:
        with(logger.getLoggingEvents()) {
            size() == 1
            get(0).message == "You cannot be {} years old!"
            get(0).arguments.get(0) == -1
            get(0).level == Level.ERROR
        }
    }

}
