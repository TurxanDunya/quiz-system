package com.example.quizsys.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Aspect
public class Audience {

    //it keeps pointcut expression inside itself
    @Pointcut("execution(* com.example.quizsys.logging.Performance.perform(..))" +
            "&& within(com.example.quizsys.logging.*)")
    public void performance() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    //Before perform(). perform() is adviced method
    @Before("performance()")
    public void before() {
        System.out.println("Silencing cell phones");
    }

    @AfterReturning(pointcut = "execution(* com.example.quizsys.logging.Performance.perform(..))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("AfterReturning is running");
        System.out.println("hijacked" + joinPoint.getSignature().getName());
        System.out.println("Method returned value is: " + result);
        System.out.println("*****");
    }

    @AfterThrowing("performance()")
    public void afterThrowing() {
        System.out.println("Demanding a refund");
    }

    @Around("performance()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Silencing cell phones");
        System.out.println("Taking seats");
        Object res = joinPoint.proceed();
        System.out.println("CLAP    CLAP CLAP!!!");
        return res;
    }
}
