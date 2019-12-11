package com.example.spock.demo_25_spring_bean

import com.example.spock.MyService
import com.example.spock.Ship
import com.example.spock.ShipStore
import com.google.common.collect.ImmutableList
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import static com.example.spock.ImmutableShip.*

@SpringBootTest
class SpringBeansV2Spec extends Specification {

    @Autowired
    MyService myService

    @SpringBean
    ShipStore shipStore = Mock()

    def "should return a list of ships"() {
        given:
        Ship enterprise = builder().name("Enterprise").allegiance("Federation").build()

        when:
        def result = myService.getShips()

        then:
        1 * shipStore.list() >> ImmutableList.of(enterprise)

        and:
        result == ImmutableList.of(enterprise)
    }

}
