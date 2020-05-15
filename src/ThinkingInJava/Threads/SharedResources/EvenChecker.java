package ThinkingInJava.Threads.SharedResources;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Alex on 31.08.2015 031.
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator g, int ident) {
        generator = g;
        id = ident;
    }

    public void run() {
        while(!generator.isCanceled()) {
            int val = generator.next();
//            System.out.println("# " + Thread.currentThread().getName());
            if(val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel(); // Отмена всех EvenChecker
            }
        }
    }
    // Тестирование произвольного типа IntGenerator:
    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < count; i++)
            exec.execute(new EvenChecker(gp, i));
        exec.shutdown();
    }

    // Значение по умолчанию для count:
    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
