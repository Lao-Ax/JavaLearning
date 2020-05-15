package com.Alex.SingletonPattern;

/**
 * Created by Alex on 16.11.2015 016.
 */
public class CodeLockedSigleton {
    private volatile static CodeLockedSigleton instance;

    private CodeLockedSigleton(){}

    public static CodeLockedSigleton getInstance(){
        if (instance == null) {
            synchronized (CodeLockedSigleton.class) {
                if (instance == null) {
                    instance = new CodeLockedSigleton();
                }
            }
        }
        return  instance;
    }

}
