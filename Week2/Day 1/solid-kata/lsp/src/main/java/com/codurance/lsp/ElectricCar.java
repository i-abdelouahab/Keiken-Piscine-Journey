package com.codurance.lsp;

public class ElectricCar implements Vehicle{
    private static final int BATTERY_FULL = 100;
    private int batteryLevel;
    private boolean engineStarted = false;

    @Override
    public void startEngine() {
        this.engineStarted = true;
    }

    @Override
    public boolean engineIsStarted() {
        return engineStarted;
    }

    @Override
    public void stopEngine() {
        this.engineStarted = false;
    }

    public void chargeBattery() {
        batteryLevel = BATTERY_FULL;
    }

    public int batteryLevel() {
        return batteryLevel;
    }
}
