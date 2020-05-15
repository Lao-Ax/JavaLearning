package kotlin_tests.interfaces

import kotlin_tests.persons.User

class ClassOne : User, interfaceTest {

    override val prop: Int = 1

    constructor(email: String) : super(email)

    override fun fun1() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fun3(x: Int): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

fun main(args: Array<String>) {
    var example = ClassOne("Alex")


}