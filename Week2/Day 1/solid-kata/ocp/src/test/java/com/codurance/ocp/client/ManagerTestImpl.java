package com.codurance.ocp.client;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ManagerTestImpl extends ManagerTest {
    private Manager manager;
    @Test
    public void payAmountReturnsExpectedAmount() {
        int salary = 9000;
        int bonus = 2000;
        manager = new Manager(salary, bonus);

        int expectedPay = salary + bonus;
        int actualPay = manager.payAmount();

        Assertions.assertEquals(expectedPay, actualPay);
    }
}
