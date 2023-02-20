package com.codurance.ocp.client;

import com.codurance.ocp.strategies.EngineerPayStrategy;

public class Engineer extends Employee {
    Engineer(int salary) {
        super(salary, new EngineerPayStrategy());
    }
}
