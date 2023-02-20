package com.codurance.lsp;

import org.jetbrains.annotations.NotNull;

public class FillingStation {
    public void refuel(PetrolCar petrolCar) {
        petrolCar.fillUpWithFuel();
    }

    public void charge(ElectricCar electricCar) {
        electricCar.chargeBattery();
    }
}
