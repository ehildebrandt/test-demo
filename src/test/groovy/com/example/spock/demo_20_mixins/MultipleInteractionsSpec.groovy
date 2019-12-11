package com.example.spock.demo_20_mixins

import spock.lang.Specification

class MultipleInteractionsSpec extends Specification implements UserInteractions, ProductInteractions, BasketInteractions {

    def "should add products to basket"() {
        given: "the user is logged in"
        loggedInAs("Spock")

        and: "navigates to a product page"
        goToProductPage("ship uniform")

        when: "adds a product to basket"
        addProductToBasket()

        then: "we expect the basket to have 1 item"
        basket.size() == 1

        and: "the item in the basket must equal the item on the product page"
        basket.get(0) == "ship uniform"
    }

}
