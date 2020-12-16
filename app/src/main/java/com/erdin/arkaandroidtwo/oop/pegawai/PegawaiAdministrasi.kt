package com.erdin.arkaandroidtwo.oop.pegawai

class PegawaiAdministrasi : Pegawai() {
    var tempatBekerja: String? = null

    fun addPegawaiAdministrasi(nama: String,
                               nip: Int, alamat: String,
                               tempatBekerja:String) {
        super.addPegawai(nama, nip, alamat)
        this.tempatBekerja = tempatBekerja
    }

    // Override
    override fun printPeg() {
        super.printPeg()
        println("Tempat bekerja: ${this.getTempatBekerjas()}")
    }

    fun getTempatBekerjas(): String? {
        return this.tempatBekerja
    }

    // OverLoad
    fun cetakInfo() {
        this.printPeg()
    }

    fun cetakInfo(keterangan: String) {
        this.printPeg()
        println("Keterangan: $keterangan")
    }

    fun cetakInfo(keterangan: String, jabatan: String) {
        this.printPeg()
        println("Keterangan: $keterangan")
        println("Jabatan: $jabatan")
    }

    fun cetakInfo(keterangan: String, jabatan: String, lamaJabatan: Int) {
        this.printPeg()
        println("Keterangan: $keterangan")
        println("Jabatan: $jabatan")
        println("Lama Jabatan: $lamaJabatan")
    }
}

fun main() {
    val pegawai = PegawaiAdministrasi()

    pegawai.addPegawaiAdministrasi("Lukman", 20201510, "Jl Cempaka Emas", "A301")
    println("----")
    pegawai.cetakInfo("PNS", "Kadin")
    println("----")
    pegawai.cetakInfo("PNS", "staff", 1)
}