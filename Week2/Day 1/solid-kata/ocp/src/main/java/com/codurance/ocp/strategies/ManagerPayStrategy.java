package com.codurance.ocp.strategies;

import com.codurance.ocp.Strategy;

public class ManagerPayStrategy implements Strategy {
    private final int bonus;

    public ManagerPayStrategy(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public int payAmount(int salary) {
        return salary + bonus;
    }
}
