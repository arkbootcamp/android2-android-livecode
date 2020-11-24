package com.erdin.arkaandroidtwo.kotlin

fun addNumbers(x: Double = 0.0, y: Double = 0.0) : Double {
    return x + y
}

fun addNumbers(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0) : Double {
    return x + y
}

fun main() {
    println("Start Function")

    var returnAdd = addNumbers(2.0, 4.0)
    println("Return add 1: $returnAdd")

    returnAdd = addNumbers(6.0, 4.0)
    println("Return add 2: $returnAdd")

    returnAdd = addNumbers(4.0)
    println("Return add 3: $returnAdd")

    returnAdd = addNumbers(4.0, 3.0, 2.0)
    println("Return add 4: $returnAdd")

}