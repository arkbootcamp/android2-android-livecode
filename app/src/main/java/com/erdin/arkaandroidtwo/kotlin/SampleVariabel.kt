package com.erdin.arkaandroidtwo.kotlin

fun main() {
//    Comment Satu line
    /* Comment multiline
       baris1
       baris 2
    */

//    Gaya Penulisan Variabel/File/Lainnya
    /*
    PascalCase -> ArkademyAndroid (File Name)
    camelCase -> androidDua (variabel, function)
    snake_case -> arkademy_bootcamp (layout xml)
    */

//    Contoh Cetak
    print("Arkademy Bootcamp")
    println("Android Batch 2")

//    Variabel Immutable
    val name = "Abdul Richard"
    val age: Int = 30

//    Variabel Mutable
    var nilai = 3.56
    println("Nilai: $nilai")
    nilai = 3.75
    println("Nilai: $nilai")
    println("Nama: $name")

//    Template Literal (recomend)
    println("Nama saya $name, umur saya $age tahun, dan saya mendapatkan nilai $nilai")

//    Concatenation
    println("Nama saya " + name + ", umur saya " + age)

    val height: Int = 1
    var weight: Int? = null

    print("Berat Badan $name: ${weight?.toDouble() ?: "100"} ")

}