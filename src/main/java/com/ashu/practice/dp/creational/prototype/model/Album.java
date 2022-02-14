package com.ashu.practice.dp.creational.prototype.model;

import com.ashu.practice.dp.creational.prototype.PrototypeCapable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Album implements PrototypeCapable {

    private String name = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public Album clone() throws CloneNotSupportedException {
        log.info("Cloning Album object");
        return (Album) super.clone();
    }
}
