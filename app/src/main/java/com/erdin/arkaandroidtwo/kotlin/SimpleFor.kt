package com.erdin.arkaandroidtwo.kotlin

fun main() {

    println("= INCREMENT =")
    for (i in 1..20 step 5) {
        println("Angka: $i")
    }

    println("= Decrement =")
    for (i in 20 downTo 1) {
        println("Angka: $i")
    }

    for (number in 1..10) {
        if (number == 5) {
            continue
        }
        println(number)
    }

    for (number in 1..10) {
        if (number == 7) {
            break
        }
        println(number)
    }

    println("end")

}