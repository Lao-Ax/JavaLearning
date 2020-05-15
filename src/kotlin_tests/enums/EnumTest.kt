package kotlin_tests.enums

import kotlin_tests.enums.Color.*

fun main(args: Array<String>) {

    println(WHITE)
    var s: String = WHITE.name
    println(Color.WHITE.hexColor)
    println(Color.WHITE.opacity)

    println(getFavoriteColor(BLACK))

    println(getFavoriteSet(BLACK, GREEN))

    val a = 2
    val b = 4
    when {
        (a > b) || (b < 0) -> println("$a > $b")
        (a < b) -> println("$a < $b")
        (a == b) -> println("$a = $b")
        else -> {println("КОШКА")}
    }
}

fun getFavoriteColor(color: Color) =
        when (color) {
            BLACK -> "черный"
            GREEN, BLACK -> "зеленый или черный"
            RED -> "красный"
            WHITE -> "белый"
            else -> "нет цвета"
        }

fun getFavoriteSet(color: Color, color2: Color): String {
    return when (setOf(color, color2)) {
        setOf(GREEN, BLACK) -> "зеленый или черный"
        setOf(RED, WHITE) -> "красный"
        else -> "нет цвета"
    }
}