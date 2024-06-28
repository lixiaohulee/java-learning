package com.singleton;

public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    public static Singleton getInstance() {
        return INSTANCE;
    }

    private Singleton() {}


    public void sayHi() {
        System.out.println("Hi~");
    }
}
