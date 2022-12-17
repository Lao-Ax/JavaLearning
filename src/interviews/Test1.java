package interviews;

import java.util.function.Consumer;

public class Test1 {

    public static void main(String[] args) {
        Consumer<Integer> c = (Integer i) -> System.out.println(i);
        try {
            System.out.println("Try");
            return;
        } catch (NullPointerException e) {
            System.out.println(e);
            return;
        } finally {
            System.out.println("Finally!");
        }
//        System.out.println("After error");
    }

}
