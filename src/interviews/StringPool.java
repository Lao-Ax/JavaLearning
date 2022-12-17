package interviews;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringPool {

    public static void main(String... args) {
        String str1 = "some string";
        String str2 = "some string";
        System.out.println(str1 == str2); // true

        String str3 = new String("some string");
        System.out.println(str1 == str3); // false

        System.out.println(str1.intern() == str3.intern()); // true

        String st1 = "TopJava";
        /*final */
        String st2 = "Java"; // c final будет true
        String st3 = "Top" + st2;

        System.out.println("Строка 1 равна строке 3? " + (st1 == st3)); // false

        System.out.println(st1.getBytes().length);
        System.out.println(Arrays.toString(st1.getBytes()));
        System.out.println(Arrays.toString(" ".getBytes()));
    }
}
