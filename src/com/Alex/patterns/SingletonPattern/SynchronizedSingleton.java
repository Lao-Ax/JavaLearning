package com.Alex.SingletonPattern;

/**
 * Такой вид одиночки подходит, если операция по синхронизации в нашем приложении нет уж дорога,
 * и мы готовы смириться с потерями производительности.
 */
public class SynchronizedSingleton {
    private static SynchronizedSingleton synchronizedSingletonInstance;

    private SynchronizedSingleton(){}

    public static synchronized SynchronizedSingleton getInstance(){
        if (synchronizedSingletonInstance == null) {
            synchronizedSingletonInstance = new SynchronizedSingleton();
        }
        return synchronizedSingletonInstance;
    }

}
