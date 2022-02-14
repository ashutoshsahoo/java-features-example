package com.ashu.practice.dp.creational.prototype;

public interface PrototypeCapable extends Cloneable {

    PrototypeCapable clone() throws CloneNotSupportedException;

}
