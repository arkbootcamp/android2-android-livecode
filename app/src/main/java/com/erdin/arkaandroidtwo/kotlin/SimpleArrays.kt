package com.erdin.arkaandroidtwo.kotlin

fun main() {

    println("Pet Shop")
    print("Enter number of pets: ")
    val maxSize:Int = readLine()!!.toInt()

    var listOfPets: Array<String> = Array(maxSize){""}

    for (i in 0 until maxSize!!) {
        print("Enter pet name: ")
        listOfPets[i] = readLine()!!
    }

    println("Your Pet")
    for (i in 0 until maxSize) {
        println("Pet $i: ${listOfPets[i]}")
    }


}