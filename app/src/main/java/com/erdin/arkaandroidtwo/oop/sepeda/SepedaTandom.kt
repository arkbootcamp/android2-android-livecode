package com.erdin.arkaandroidtwo.oop.sepeda

class SepedaTandom : Sepeda() {
    var jumSadel = 0

    fun addSadel(jumlahSadel: Int) {
        jumSadel = jumlahSadel
        println("Jumlah sadel: $jumlahSadel")
    }
}