package kotlin_tests.enums

enum class Color(val hexColor : String, val opacity : Double = 1.0) {
    WHITE("#ff"),
    BLACK("#00"),
    RED("#1f", 0.5),
    GREEN("#11")
}