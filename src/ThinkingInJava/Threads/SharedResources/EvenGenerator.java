package ThinkingInJava.Threads.SharedResources;

/**
 * Created by Alex on 31.08.2015 031.
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    public synchronized int next() {
        ++currentEvenValue;  // Опасная точка!
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
