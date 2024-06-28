package com.singleton;

public class TestSingleTon {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();

        s.sayHi();
    }
}
