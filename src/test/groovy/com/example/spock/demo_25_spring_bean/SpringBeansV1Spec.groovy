package com.example.spock.demo_25_spring_bean

import com.example.spock.MyService
import com.example.spock.ShipStore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class SpringBeansV1Spec extends Specification {

    @Autowired
    MyService myService

    @Autowired
    ShipStore shipStore

    def "should return a list of ships"() {
        expect:
        myService.getShips() == shipStore.list()
    }

}
