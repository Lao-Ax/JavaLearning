package ThinkingInJava.Threads.SharedResources.CircularSetTest;

import java.util.concurrent.*;

/**
 * Created by Alex on 07.09.2015 007.
 */
public class SerialNumberChecker {
    private static final int SIZE = 10;
    private static final CircularSet serials = new CircularSet(1000);
    private static final ExecutorService exec = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable {
        public void run() {
            while(true) {
                int serial = SerialNumberGenerator.nextSerialNumber();
                if(serials.contains(serial)) {
                    System.out.println("Duplicate: " + serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        for(int i = 0; i < SIZE; i++) // запуск 10 потоков.
            exec.execute(new SerialChecker());

        // Остановиться после n секунд при наличии аргумента:
        if(args.length > 0) {
            TimeUnit.SECONDS.sleep(Integer.parseInt(args[0]));
            System.out.println("No duplicates detected");
            System.exit(0);
        }
    }
}
