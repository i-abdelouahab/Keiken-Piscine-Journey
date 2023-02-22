package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Before("execution(* com.aop.ShoppingCard.checkout())")
    public void logger() {
        System.out.println("Logged In");
    }

    @Around("@annotation(com.aop.TimeIt)")
    public Object timeIt(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by " + joinPoint.getSignature().getName() + " method: " + (endTime - startTime) + "ms");
        return result;
    }

    @After("execution(* com.aop.ShoppingCard.checkout())")
    public void killer() {
        System.out.println("Logged Out");
    }
}
