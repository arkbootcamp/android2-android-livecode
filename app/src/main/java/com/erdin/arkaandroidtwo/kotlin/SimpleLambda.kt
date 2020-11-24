package com.erdin.arkaandroidtwo.kotlin

val sum = {number1: Int, number2: Int ->
    number1 + number2
}

fun main() {
    println("List of numbers")
    val listOfNumbers = listOf(10, 15, 22, 33, 40)

    listOfNumbers.forEach { angka -> println(angka) }


    val addNumber = sum(10, 20)
    println("Hasilnya: $addNumber")
}