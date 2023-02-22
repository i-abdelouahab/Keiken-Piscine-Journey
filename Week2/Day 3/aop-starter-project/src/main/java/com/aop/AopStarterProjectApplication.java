package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopStarterProjectApplication {
    public static void main(String[] args) {

        ApplicationContext context
                = new AnnotationConfigApplicationContext(BeanConfig.class);

        ShoppingCard card = context.getBean(ShoppingCard.class);
        card.checkout();

    }

}
