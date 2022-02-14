package com.ashu.practice.dp.creational.factory;

import lombok.extern.slf4j.Slf4j;

enum ShapeType {
    CIRCLE, SQUARE, RECTANGLE
}

public class FactoryExample {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.buildShape(ShapeType.CIRCLE);
        circle.printShape();
        circle.calculateArea();
        Shape rectangle = ShapeFactory.buildShape(ShapeType.RECTANGLE);
        rectangle.printShape();
        rectangle.calculateArea();
        Shape square = ShapeFactory.buildShape(ShapeType.SQUARE);
        square.printShape();
        square.calculateArea();
    }

}
/*
06:18:27.273 [main] INFO  com.ashu.practice.dp.factory.Shape.printShape(48) - This is a CIRCLE shape
06:18:27.273 [main] INFO  com.ashu.practice.dp.factory.Circle.calculateArea(77) - calculating area of circle
06:18:27.273 [main] INFO  com.ashu.practice.dp.factory.Shape.printShape(48) - This is a RECTANGLE shape
06:18:27.273 [main] INFO  c.ashu.practice.dp.factory.Rectangle.calculateArea(91) - calculating area of Rectangle
06:18:27.273 [main] INFO  com.ashu.practice.dp.factory.Shape.printShape(48) - This is a SQUARE shape
06:18:27.273 [main] INFO  com.ashu.practice.dp.factory.Square.calculateArea(63) - calculating area of Square
 */

class ShapeFactory {

    private ShapeFactory() {
    }

    public static Shape buildShape(ShapeType type) {
        return switch (type) {
            case CIRCLE -> new Circle(type);
            case SQUARE -> new Square(type);
            case RECTANGLE -> new Rectangle(type);
        };
    }
}

@Slf4j
abstract class Shape {

    private final ShapeType type;

    protected Shape(ShapeType type) {
        this.type = type;
    }

    public void printShape() {
        log.info("This is a {} shape", type.name());
    }

    abstract void calculateArea();
}

@Slf4j
class Square extends Shape {

    protected Square(ShapeType type) {
        super(type);
    }

    @Override
    void calculateArea() {
        log.info("calculating area of Square");
    }
}


@Slf4j
class Circle extends Shape {

    protected Circle(ShapeType type) {
        super(type);
    }

    @Override
    void calculateArea() {
        log.info("calculating area of circle");
    }
}


@Slf4j
class Rectangle extends Shape {

    protected Rectangle(ShapeType type) {
        super(type);
    }

    @Override
    void calculateArea() {
        log.info("calculating area of Rectangle");
    }
}