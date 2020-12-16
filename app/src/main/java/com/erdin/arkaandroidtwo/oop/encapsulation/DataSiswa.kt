package com.erdin.arkaandroidtwo.oop.encapsulation

class DataSiswa {
    var nama:String? = null
    var nis:String? = null
    var kelas:String? = null
    private var nilaiKu:Int = 0

    fun setNilai(nilai:Int) {
        nilaiKu = nilai
    }

    fun getNilai(): Int {
        return nilaiKu
    }
}

fun main() {
    val biodata = DataSiswa()
    biodata.nama = "Rosalia"
    biodata.kelas = "2B"
    biodata.nis = "022222"
    biodata.setNilai(90)

    println("Nama siswa: ${biodata.nama}")
    println("NIS siswa: ${biodata.nis}")
    println("Kelas siswa: ${biodata.kelas}")
    println("Nilai siswa: ${biodata.getNilai()}")
}
