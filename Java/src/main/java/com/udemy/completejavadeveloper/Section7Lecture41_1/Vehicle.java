package com.udemy.completejavadeveloper.Section7Lecture41_1;

/**
 * @author: pgajjar
 * @since: 8/24/17
 */
public class Vehicle {
    private double speed;
    private final String type;
    private final short seats;

    public Vehicle(double speed, String type, short seats) {
        this.speed = speed;
        this.type = type;
        this.seats = seats;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {

        return speed;
    }

    public String getType() {
        return type;
    }

    public short getSeats() {
        return seats;
    }

    public void move() {

    }
}
