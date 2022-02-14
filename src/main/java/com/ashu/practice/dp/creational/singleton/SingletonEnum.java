package com.ashu.practice.dp.creational.singleton;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
public enum SingletonEnum implements Serializable {
    INSTANCE;

    public void something() {
        log.info("some method");
    }

    private int i = 10;


    public int getI() {
        return i;
    }

    void setI(int i) {
        this.i = i;
    }
}
