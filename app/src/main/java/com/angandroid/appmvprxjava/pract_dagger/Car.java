package com.angandroid.appmvprxjava.pract_dagger;

public class Car {

    private Motor motor;

    public Car(Motor motor) {
        this.motor = motor;
    }

    public String getMotor() {
        return "Coche con: " + motor.getTypeMotor();
    }
}
