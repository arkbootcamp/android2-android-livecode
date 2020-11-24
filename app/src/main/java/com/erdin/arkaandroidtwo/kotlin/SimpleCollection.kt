package com.erdin.arkaandroidtwo.kotlin

/*
    Mutable -> Read and Write, or add more
    Immutable -> Read Only
*/

fun main() {

    println("= Immutable =")
    val listImmutable = listOf(
        "Anggur", "Jeruk", "Apel", "Durian", "Naga",
        "Salak", "Peer", "Asem", "Melon", "Mangga")

    for (fruit in listImmutable) {
        println("Buah ku: $fruit")
    }

    println("= Mutable =")
    var listMutable = mutableListOf("Burger", "Pizza", "Spaghetti", "Mendoan", "Pecel")
    listMutable[4] = "Ayam McD"
    listMutable.add("Ayam KFC")
    for (food in listMutable) {
        println(food)
    }

}