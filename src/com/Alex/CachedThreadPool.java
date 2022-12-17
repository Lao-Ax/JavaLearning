package com.Alex;

import java.util.concurrent.*;

public class CachedThreadPool {
    public static void main(String[] args) {
        try (ExecutorService exec = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 5; i++)
                exec.execute(new LiftOff());
            exec.shutdown();
        }
    }
}
