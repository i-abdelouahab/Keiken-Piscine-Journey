package com.codurance.ocp.client;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class EngineerTestImpl {
    private Engineer engineer;
    @Test
    public void payAmountReturnsExpectedAmount() {
        int salary = 8000;
        engineer = new Engineer(salary);

        int expectedPay = salary;
        int actualPay = engineer.payAmount();

        Assertions.assertEquals(expectedPay, actualPay);
    }
}
