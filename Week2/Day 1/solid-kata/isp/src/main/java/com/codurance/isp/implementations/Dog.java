package com.codurance.isp.implementations;

import com.codurance.isp.interfaces.Barkable;

public class Dog implements Runnable, Barkable {
    @Override
    public void bark() {
        System.out.print("Dog is barking");
    }

    @Override
    public void run() {
        System.out.print("Dog is running");
    }
}
