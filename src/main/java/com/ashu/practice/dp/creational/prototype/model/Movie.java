package com.ashu.practice.dp.creational.prototype.model;

import com.ashu.practice.dp.creational.prototype.PrototypeCapable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Movie implements PrototypeCapable{

    private String name = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public Movie clone() throws CloneNotSupportedException {
        log.info("Cloning Movie object");
        return (Movie) super.clone();
    }
}
