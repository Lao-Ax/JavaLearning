package ThinkingInJava.Threads.SharedResources.CircularSetTest;

/**
 * Created by Alex on 07.09.2015 007.
 */
public class CircularSet {
    private final int[] array;
    private final int len;
    private int index = 0;

    public CircularSet(int size) {
        array = new int[size];
        len = size;
        // Инициализируем значением, которое не производится классом SerialNumberGenerator:
        for(int i = 0; i < size; i++)
            array[i] = -1;
    }
    public synchronized void add(int i) {
        array[index] = i;
        index = ++index % len; // Возврат индекса к началу с записью поверх старых значений:
    }
    public synchronized boolean contains(int val) {
        for(int i = 0; i < len; i++)
            if(array[i] == val) return true;
        return false;
    }
}
