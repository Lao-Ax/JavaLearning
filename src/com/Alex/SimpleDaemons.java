package com.Alex;

import java.util.concurrent.*;

/**
 * Created by Alex on 29.08.2015 029.
 */
public class SimpleDaemons implements Runnable{
    public void run() {
        try {
            while(true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch(InterruptedException e) {
            System.out.println("sleep() interrupted");
        }
    }
    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true); // Необходимо вызвать перед start()
            daemon.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }

}
