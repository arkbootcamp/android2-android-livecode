package com.erdin.arkaandroidtwo.oop

data class Student(var name:String?, var age: Int?, var sex:String?)

fun main() {
    val student = Student("Miqdad", 22, "M")
    Student("Ikrima", 24, "W")
    student.name
    student.age
}