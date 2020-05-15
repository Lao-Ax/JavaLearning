package com.Alex.SingletonPattern;

/**
 * Удачен, если наш объект нужен всегда и хранить его в памяти - не обременительно.
 */
public class PreCreatedSingleton {
    private static PreCreatedSingleton instance = new PreCreatedSingleton();

    private PreCreatedSingleton() {}

    public static PreCreatedSingleton getInstance(){
        return instance;
    }
}
