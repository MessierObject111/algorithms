package com.designPatterns.singletons;

public class SingletonA {

    private static volatile SingletonA singleton;

    private SingletonA () {

    }
    // Why can't we just put a synchronized block here before getSingleton()?
    // Because if we do, only one thread can access this getSingleton() at a time, and when many threads
    // are calling this method, it will cause bad performance. We should allow concurrent access to it
    // and return the same instance instead of blocking them.
    public static SingletonA getSingleton() {
        if(singleton == null) {
            synchronized (SingletonA.class) {
                if(singleton == null) {
                    return new SingletonA(); //We can just return it
                }
            }
        }
        return singleton;
    }
}
