package com.ashu.practice.dp.creational.singleton;

import java.io.Serial;
import java.io.Serializable;

public class SingletonStatic implements Serializable {

    @Serial
    private static final long serialVersionUID = 7776819768824099886L;
    private int i = 10;

    private SingletonStatic() {
    }

    public static SingletonStatic getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Serial
    protected Object readResolve() {
        return getInstance();
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    private static class SingletonHolder {
        private static final SingletonStatic INSTANCE = new SingletonStatic();
    }
}
