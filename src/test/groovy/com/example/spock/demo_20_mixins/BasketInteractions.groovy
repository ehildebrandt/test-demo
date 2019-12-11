package com.example.spock.demo_20_mixins

trait BasketInteractions {

    List basket = new ArrayList()

    abstract getSelectedProduct()

    void addProductToBasket() {
        println "Adding product '" + selectedProduct + "' to basket"
        basket.add(getSelectedProduct())
        println "Product '" + selectedProduct + "' added"
    }

}
