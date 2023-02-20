package com.codurance.lsp;

public class PetrolCar implements Vehicle {
  private static final int FUEL_TANK_FULL = 100;
  private int fuelTankLevel = 0;
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

  public void fillUpWithFuel() {
    this.fuelTankLevel = FUEL_TANK_FULL;
  }

  public int fuelTankLevel() {
    return fuelTankLevel;
  }
}
