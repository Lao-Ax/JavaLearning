package kotlin_tests.persons

fun main(args : Array<String>) {
    val userJava : UserJava = UserJava("lao-ax@yanex.ru");
    println(userJava.email);
//    userJava.email = "test" // error, because it is final.

    val user : User = User("lao-ax@narod.ru");
//    println(user.email);
//    user.email = "test" // error, because it is val == final. If you make it var - so no errors.

    var int : Int = 1;
    var long : Long = 123;
    var float : Float = 1.4F;
    var double : Double = 1.5;
    var short : Short = 256;
    var byte : Byte = 127;
    var char : Char = 'a';
    var char2 : Char = 15.toChar();
    var boolean : Boolean = false;

    var a : Long = int.toLong();
    var a1 : Long = long + 123;
    var b : Int = byte + 1;
    var b2 : Int = short + 1;

}