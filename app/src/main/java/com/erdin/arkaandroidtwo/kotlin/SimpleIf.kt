package com.erdin.arkaandroidtwo.kotlin

fun main() {
    val a  = 60
    var b = 40

    if (a > b) {
        println("SUM: ${a + b}")
    } else {
        println("Pengurangan: ${a - b}")
    }

    print("Input your grade: ")
    val grade: Int = readLine()!!.toInt()

    if (grade >= a) {
        b += 50
        println("Your grade is A")
        println("Nilai b sekarang $b")
    } else {
        println("Failed!")
    }

}