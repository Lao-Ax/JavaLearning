package kotlin_tests

class HelloWorld {
    val word : String = "world";

    fun greet() {
        println("Hello, $word!");
    }
}

class Counter {
    var x : Int = 1;
    var y : Int = 2;

    fun count() : Int {
        return x + y;
    }
}

fun main(args : Array<String>) {
    HelloWorld().greet();
    var counter : Counter = Counter();
    println("The result of ${counter.x} + ${counter.y} is ${counter.count()}");

    var n = 1
    var r = when (n) {
        1 -> "ONE"
        2 -> "TWO"
        3 -> "THREE"
        4 -> "FOUR"
        5 -> "FIVE"
        6 -> "SIX"
        else -> "NONE"
    }

    print(r)
}