package kotlin_tests.persons

open class User {
    constructor(email : String)

    var days : Int = 0
    get() {
        return field
    }

    constructor(name : String, ages : Int) : this(name) {
        days = ages * 365
    }

//    fun getEmail() : String { //error
//        return email + "000"
//    }
}