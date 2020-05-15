package ThinkingInJava.Threads.SharedResources;

import java.util.concurrent.*;
import java.util.*;

class Accessor implements Runnable {
    private final int id;

    public Accessor(int idn) { id = idn; }

    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }
    public String toString() {
        return "#" + id + ": " +
                ThreadLocalVariableHolder.get();
    }
}

public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value =
            new ThreadLocal<Integer>() {
                private Random rand = new Random(47);
                protected synchronized Integer initialValue() {
                    return rand.nextInt(10000);
                }
            };

    public static void increment() {
        value.set(value.get() + 1);
    }

    public static int get() { return value.get(); }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
            exec.execute(new Accessor(i));
        TimeUnit.SECONDS.sleep(3);   // Небольшая задержка
        exec.shutdownNow();          // Выход из всех объектов Accessor
    }
}

/* Объекты ThreadLocal обычно хранятся в статических полях. Если вы создаете объект ThreadLocal,
 * для обращения к содержимому объекта можно использовать только методы get() и set().
 * Метод get() возвращает копию объекта, ассоцииро­ванного с потоком,
 * a set() сохраняет свой аргумент в объекте потока, возвращая ранее хранившийся объект.
 * Их использование продемонстрировано в методах increment() и get() класса ThreadLocalVariableHolder.
 * Обратите внимание: методы increment() и get() не синхронизированы,
 * потому что ThreadLocal не гарантирует отсутствия «ситуации гонки».
 */