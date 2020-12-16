package com.erdin.arkaandroidtwo.oop.sepeda

class SepedaGunungAksi {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Set Object
            val sepedaKu = SepedaGunung()

            // Pemanggilan object
            sepedaKu.ubahGir(3)
            sepedaKu.tambahKecepatan(40)
            sepedaKu.setSadel(3)
        }
    }
}