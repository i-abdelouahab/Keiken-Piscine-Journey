package com.aop;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCard {
    @TimeIt
    public void checkout() {
        //Logging
        //Authorization and Authentication
        System.out.println("Checkout method is called from ShoppingCard");
    }
}
