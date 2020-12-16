package com.erdin.arkaandroidtwo.oop.sepeda

class SepedaTandemAksi {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val sepedaTandomKu = SepedaTandom()

            sepedaTandomKu.ubahGir(1)
            sepedaTandomKu.tambahKecepatan(20)
            sepedaTandomKu.addSadel(3)
        }
    }
}