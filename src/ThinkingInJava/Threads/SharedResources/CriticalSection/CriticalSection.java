package ThinkingInJava.Threads.SharedResources.CriticalSection;

/**
 * Created by Alex on 10.09.2015 010.
 */
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.*;

class Pair { // Not thread-safe
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() { this(0, 0); } // конструктор "по умолчанию"

    public int getX() { return x; }
    public int getY() { return y; }

    public void incrementX() { x++; }
    public void incrementY() { y++; }

    public String toString() {
        return "x: " + x + ", y: " + y;
    }

    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("Pair values not equal: " + Pair.this);
        }
    }

    // Произвольный инвариант - обе переменные должны быть:
    public void checkState() {
        if(x != y)
            throw new PairValuesNotEqualException();
    }
}

// Защита класса Pair внутри приспособленного к потокам класса:
abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<>());

    public synchronized Pair getPair() {
        // Создаем копию, чтобы сохранить оригинал в безопасности:
        return new Pair(p.getX(), p.getY());
    }

    // Предполагается, что операция занимает некоторое время
    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch(InterruptedException ignore) {}
    }

    public abstract void increment();
}

// реализация 1
// Синхронизация всего метода:
class PairManager1 extends PairManager {
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

// реализация 2
// Использование критической секции:
class PairManager2 extends PairManager {
    public void increment() {
        Pair temp;
        synchronized(this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}

// класс который выызвает метод инкремента
class PairManipulator implements Runnable {
    private PairManager pm;

    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    public void run() {
        while(true)
            pm.increment();
    }
    public String toString() {
        return "Pair: " + pm.getPair() + " checkCounter = " + pm.checkCounter.get();
    }
}

// класс который проверяет состояние пары
class PairChecker implements Runnable {
    private PairManager pm;

    public PairChecker(PairManager pm) {
        this.pm = pm;
    }
    public void run() {
        while(true) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}

public class CriticalSection {
    // Сравнение двух подходов:
    static void testApproaches(PairManager pman1, PairManager pman2) {
        ExecutorService exec = Executors.newCachedThreadPool();

        PairManipulator
                pm1 = new PairManipulator(pman1),
                pm2 = new PairManipulator(pman2);

        PairChecker
                pcheck1 = new PairChecker(pman1),
                pcheck2 = new PairChecker(pman2);

        exec.execute(pm1);
        exec.execute(pm2);
        exec.execute(pcheck1);
        exec.execute(pcheck2);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch(InterruptedException e) {
            System.out.println("Sleep interrupted");
        }
        System.out.println("pm1: " + pm1 + "\npm2: " + pm2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager
                pman1 = new PairManager1(),
                pman2 = new PairManager2();

        testApproaches(pman1, pman2);
    }
}
