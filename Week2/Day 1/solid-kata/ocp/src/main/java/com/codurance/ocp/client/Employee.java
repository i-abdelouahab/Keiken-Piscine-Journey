package com.codurance.ocp.client;

import com.codurance.ocp.Strategy;

public abstract class Employee {

    private final int salary;
    private final Strategy strategy;

    Employee(int salary, Strategy strategy) {
        this.salary = salary;
        this.strategy = strategy;
    }

    public int payAmount() {
        return strategy.payAmount(salary);
    }

}