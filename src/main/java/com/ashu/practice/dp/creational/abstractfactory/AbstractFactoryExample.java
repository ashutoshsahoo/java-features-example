package com.ashu.practice.dp.creational.abstractfactory;


enum CarType {
    SMALL, SEDAN, LUXURY
}

enum Location {
    USA, ASIA, DEFAULT
}


public class AbstractFactoryExample {
    public static void main(String[] args) {
        Car smallAsiaCar = CarFactory.buildCar(CarType.SMALL);

        smallAsiaCar.construct();
    }
}

class CarFactory {
    private CarFactory() {
    }

    public static Car buildCar(CarType type) {
        Location location = Location.ASIA; // use some internal logic to find location
        return switch (location) {
            case ASIA -> AsiaCarFactory.buildCar(type);
            case USA -> UsaCarFactory.buildCar(type);
            case DEFAULT -> DefaultCarFactory.buildCar(type);
        };
    }
}

class AsiaCarFactory {
    public static Car buildCar(CarType type) {
        return switch (type) {
            case SMALL -> new SmallCar(Location.ASIA);
            case SEDAN -> new SedanCar(Location.ASIA);
            case LUXURY -> new LuxuryCar(Location.ASIA);
        };
    }
}


class UsaCarFactory {
    public static Car buildCar(CarType type) {
        return switch (type) {
            case SMALL -> new SmallCar(Location.USA);
            case SEDAN -> new SedanCar(Location.USA);
            case LUXURY -> new LuxuryCar(Location.USA);
        };
    }
}


class DefaultCarFactory {
    public static Car buildCar(CarType type) {
        return switch (type) {
            case SMALL -> new SmallCar(Location.DEFAULT);
            case SEDAN -> new SedanCar(Location.DEFAULT);
            case LUXURY -> new LuxuryCar(Location.DEFAULT);
        };
    }
}


abstract class Car {

    private final CarType type;
    private final Location location;

    protected Car(CarType type, Location location) {
        this.type = type;
        this.location = location;
    }

    protected abstract void construct();

    public CarType getType() {
        return type;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type=" + type +
                ", location=" + location +
                '}';
    }
}


class SmallCar extends Car {

    public SmallCar(Location location) {
        super(CarType.SMALL, location);
    }

    @Override
    protected void construct() {
        System.out.println("Building smallCar in " + getLocation());
    }
}


class SedanCar extends Car {

    public SedanCar(Location location) {
        super(CarType.SEDAN, location);
    }

    @Override
    protected void construct() {
        System.out.println("Building SedanCar in " + getLocation());
    }
}


class LuxuryCar extends Car {

    public LuxuryCar(Location location) {
        super(CarType.LUXURY, location);
    }

    @Override
    protected void construct() {
        System.out.println("Building LuxuryCar in " + getLocation());
    }
}

