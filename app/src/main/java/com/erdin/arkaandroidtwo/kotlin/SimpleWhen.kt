package com.erdin.arkaandroidtwo.kotlin

fun main() {
    print("Pilih menu: ")
    val foodId: Int? = readLine()?.toInt()

    when (foodId) {
        1 -> {
            println("1. Ayam Goreng")
            println("2. Nasi")
            println("3. Es Teh Manis")
        }

        2 -> {
            println("1. Lele Goreng")
            println("2. Nasi")
            println("3. Teh Anget")
        }

        3 -> {
            println("1. Bebek Goreng")
            println("2. Nasi")
            println("3. Teh Tawar")
        }

        else -> {
            println("Menu tidak ditemukan")
        }

    }

}