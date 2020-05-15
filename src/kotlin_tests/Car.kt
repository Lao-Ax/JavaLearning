package kotlin_tests

class Car(
        private var weight: Double,
        var size: Double
) {
    var isNew: Boolean = false
        get() {
            return weight > size
        }
        set(value) {
            println("Вызов isNew метода.")
            field = value
        }

    val isOld: Boolean
        get() {
            return weight < size
        }

    fun getWeight(): Double {
        return weight + 100;
    }
}