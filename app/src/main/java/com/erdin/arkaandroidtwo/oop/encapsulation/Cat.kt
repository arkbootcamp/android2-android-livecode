package com.erdin.arkaandroidtwo.oop.encapsulation

class Cat {
    var mood: Int = 0
    private var hungry: Int = 0
    private var energy: Int = 0

    private fun meow() {
        println("Meow!!")
    }

    fun sleep() {
        energy++
        hungry++
        status()
    }

    fun play() {
        mood++
        energy--
        status()
    }

    fun feed() {
        hungry--
        mood++
        energy++
        meow()
        status()
    }

    fun status() {
        println("Mood: $mood")
        println("Hungry: $hungry")
        println("Energi: $energy")
    }
}

fun main() {
    val cat = Cat()
    cat.play()
    cat.feed()
}