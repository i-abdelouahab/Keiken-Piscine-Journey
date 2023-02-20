package com.codurance.isp.implementations;

import com.codurance.isp.interfaces.Flyable;

public class Bird implements Runnable, Flyable {
    @Override
    public void fly() {
        System.out.print("Bird is flying");
    }

    @Override
    public void run() {
        System.out.print("Bird is running");
    }
}
