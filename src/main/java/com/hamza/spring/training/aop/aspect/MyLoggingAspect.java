package com.hamza.spring.training.aop.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

    // This is where we add all of our related advices for logging

    // Let's start with an @Before advice

    @Pointcut("execution( * add*(*,..))")
    private void forDaoPackage(){};

    @Pointcut("execution( * get*(..))")
    private void getter(){};

    @Pointcut("execution( * set*(..))")
    private void setter(){};

    @Pointcut("forDaoPackage() && !getter() && !setter()")
    private void forAllMethodsExcludeGetterAndSetter(){};

    @Before("forAllMethodsExcludeGetterAndSetter()")
    public void  beforeAddAccountAdvice() {
        System.out.println("\n ======>>> Executing @Before advice of the addAccount() method.");
    }

}
