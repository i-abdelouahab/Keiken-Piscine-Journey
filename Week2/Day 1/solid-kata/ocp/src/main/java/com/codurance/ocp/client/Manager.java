package com.codurance.ocp.client;

import com.codurance.ocp.strategies.ManagerPayStrategy;

public class Manager extends Employee {
    Manager(int salary, int bonus) {
        super(salary, new ManagerPayStrategy(bonus));
    }
}
