package ThinkingInJava.Threads.SharedResources.DeadLock;

//: concurrency/DeadlockingDiningPhilosophers.java
// Демонстрация скрытой возможности взаимной блокировки.
// {Args: 0 5 timeout}

import java.util.concurrent.*;

public class DeadlockingDiningPhilosophers {
    public static void main(String[] args) throws Exception {
        int ponder = 5;
        if (args.length > 0)
            ponder = Integer.parseInt(args[0]);

        int size = 5;
        if (args.length > 1)
            size = Integer.parseInt(args[1]);

        ExecutorService exec = Executors.newCachedThreadPool();

        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++)
            sticks[i] = new Chopstick();

        /* Для предотвращения блокировки достаточно, чтобы последний философ взял
        сначала левую палочку, а затем - правую, в отличие от других философов.
        for (int i = 0; i < size; i++) {
            if (i < (size-1)) {
                exec.execute(new Philosopher(sticks[i], sticks[i+1], i, ponder));
            } else {
                exec.execute(new Philosopher(sticks[0], sticks[i], i, ponder));
        }
        */
        for (int i = 0; i < size; i++)
            exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, ponder));

        if (args.length == 3 && args[2].equals("timeout"))
            TimeUnit.SECONDS.sleep(5);
        else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
} /* (Execute to see output) *///:~

/*
Deadlock can occur if four conditions are simultaneously met:
1. Взаимное исключение. По крайней мере один ресурс, используемый задачами, не должен
быть общим. В этом случае палочками для еды может пользоваться только один Философ
одновременно.
2. По крайней мере одна задача должна удерживать ресурс и ожидать получения ресурса
в данный момент, удерживаемый другой задачей. То есть, чтобы возник тупик, Философ
должен держать одну палочку для еды и ждать еще одну.
3. Ресурс нельзя заранее отобрать у задачи. Задачи освобождают ресурсы только как
обычное событие. Наши Философы вежливы и не берут палочки для еды у других Философов.
4. Может произойти циклическое ожидание, когда задача ожидает ресурса, удерживаемого
другой задачей, которая, в свою очередь, ожидает ресурса, удерживаемого другой задачей,
и так далее, пока одна из задач не ожидает ресурса, удерживаемого первой задачей,
тем самым блокируя все. В DeadlockingDiningPhilosophers.java циклическое ожидание
происходит потому, что каждый Философ пытается сначала получить правую палочку для еды,
а затем левую.
*/