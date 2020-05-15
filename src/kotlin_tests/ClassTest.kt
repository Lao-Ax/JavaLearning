package kotlin_tests

import kotlin_tests.persons.User

var user = User("Alex")

fun main(args: Array<String>) {
//    user = "asdf"
    val car = Car(20.5, 10.1)
    println(car.isNew)
    println(car.isOld)

    car.isNew = false

    println(car.getWeight())
    println(car.size)

    var list: ArrayList<String> = ArrayList();
    list.add("a1").and(list.add("a2"))
    list.add("a3").also {
        list.add("a4")
    }
    list.add("a5").apply {
        list.add("a6")
    }
    list.forEach {
        println(it)
    }
}