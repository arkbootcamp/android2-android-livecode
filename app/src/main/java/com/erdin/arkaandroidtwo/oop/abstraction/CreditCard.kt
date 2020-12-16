package com.erdin.arkaandroidtwo.oop.abstraction

abstract class CreditCard {
    fun creditId():String {
        return "123456789"
    }

    abstract fun newCreditCard()
}

class UserInfo: CreditCard() {
    fun getInfo(): String {
        return creditId()
    }

    override fun newCreditCard() {
        println("Credit card created!")
    }
}

fun main() {
    val credit = UserInfo()
    println(credit.getInfo())
    credit.newCreditCard()
}