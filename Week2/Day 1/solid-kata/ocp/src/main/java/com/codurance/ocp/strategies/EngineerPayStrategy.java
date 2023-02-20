package com.codurance.ocp.strategies;

import com.codurance.ocp.Strategy;

public class EngineerPayStrategy implements Strategy {
    @Override
    public int payAmount(int salary) {
        return salary;
    }
}
