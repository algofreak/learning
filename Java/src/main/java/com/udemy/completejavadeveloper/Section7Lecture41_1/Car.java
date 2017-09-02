package com.udemy.completejavadeveloper.Section7Lecture41_1;

/**
 * @author: pgajjar
 * @since: 8/24/17
 */
public class Car extends Vehicle {
    private final short wheels;
    private final short engine;
    private final String fuelType;
    private final short gears;
    private short gearPosition;
    private final short windows;
    private String listOfFeatures;

    public Car(double speed, String type, short seats, short wheels, short engine, String fuelType, short gears, short windows, String listOfFeatures) {
        super(speed, type, seats);
        this.wheels = wheels;
        this.engine = engine;
        this.fuelType = fuelType;
        this.gears = gears;
        this.windows = windows;
        this.listOfFeatures = listOfFeatures;
    }

    @Override
    public void move() {
        super.move();
    }

    public void setGearPosition(short gearPosition) {
        this.gearPosition = gearPosition;
    }

    public short getWheels() {
        return wheels;
    }

    public short getEngine() {
        return engine;
    }

    public String getFuelType() {
        return fuelType;
    }

    public short getGears() {
        return gears;
    }

    public short getGearPosition() {
        return gearPosition;
    }

    public short getWindows() {
        return windows;
    }

    public String getListOfFeatures() {
        return listOfFeatures;
    }
}
