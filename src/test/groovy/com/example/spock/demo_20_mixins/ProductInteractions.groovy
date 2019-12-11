package com.example.spock.demo_20_mixins

trait ProductInteractions {

    String selectedProduct

    void goToProductPage(String name) {
        println "Going to product page '" + name + "'"
        selectedProduct = name
        println "Product page '" + name + "' loaded"
    }

}
