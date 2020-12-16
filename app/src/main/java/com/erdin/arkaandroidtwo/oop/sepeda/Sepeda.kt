package com.erdin.arkaandroidtwo.oop.sepeda

/**
 * INHERITANCE CONCEPT
 */

open class Sepeda {
    var gir = 0
    var kecepatan = 0

    fun ubahGir(pertambahanGir:Int) {
        gir += pertambahanGir
        println("Gir: $gir")
    }

    fun tambahKecepatan(pertambahanKecepatan:Int) {
        kecepatan += pertambahanKecepatan
        println("Kecepatan: $kecepatan")
    }
}