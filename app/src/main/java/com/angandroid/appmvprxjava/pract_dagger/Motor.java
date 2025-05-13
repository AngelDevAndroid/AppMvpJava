package com.angandroid.appmvprxjava.pract_dagger;

public class Motor {

    private String typeMotor;
    public Motor(String typeMotor) {
        this.typeMotor = typeMotor;
    }

    public String getTypeMotor() {
        return "Motor: " + typeMotor;
    }

    public void setTypeMotor(String typeMotor) {
        this.typeMotor = typeMotor;
    }
}
