package ThinkingInJava.Threads.SharedResources.DeadLock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/*
In this program, the easiest way to prevent deadlock is to break the fourth condition.
This condition happens because each Philosopher is trying to pick up its Chopsticks in
a particular sequence: first right, then left. Because of that, it’s possible to get into
a situation where each of them is holding its right Chopstick and waiting to get the left,
causing the circular wait condition. However, if the last Philosopher is initialized to
try to get the left chopstick first and then the right, that
Philosopher will never prevent the Philosopher on the immediate right from picking up
their its chopstick. In this case, the circular wait is prevented.
 */

public class Philosopher implements Runnable {
    private final Chopstick left;
    private final Chopstick right;
    private final int id;
    private final int ponderFactor;
    private final Random rand = new Random(47);

    private void pause() throws InterruptedException {
        if (ponderFactor == 0) return;
        TimeUnit.MILLISECONDS.sleep(
                rand.nextInt(ponderFactor * 250));
    }

    public Philosopher(Chopstick left, Chopstick right, int ident, int ponder) {
        this.left = left;
        this.right = right;
        id = ident;
        ponderFactor = ponder;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(this + " " + "thinking");
                pause();
                // Философ проголодался
                System.out.println(this + " " + "grabbing right");
                right.take();
                System.out.println(this + " " + "grabbing left");
                left.take();
                System.out.println(this + " " + "eating");
                pause();
                right.drop();
                left.drop();
            }
        } catch (InterruptedException e) {
            System.out.println(this + " " + "exiting via interrupt");
        }
    }

    public String toString() {
        return "Philosopher " + id;
    }
}