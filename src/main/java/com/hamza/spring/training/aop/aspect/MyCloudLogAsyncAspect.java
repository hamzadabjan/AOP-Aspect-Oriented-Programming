package com.hamza.spring.training.aop.aspect;

import com.hamza.spring.training.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("com.hamza.spring.training.aop.aspect.MyLoggingAspect.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync(JoinPoint joinPoint) {
        System.out.println("\n=====>>> This Advice Executed #1");

        // get method signature
        System.out.println("Method: "+ joinPoint.getSignature());

        // display method arguments
        Object[] args = joinPoint.getArgs();
        for(Object arg: args){
            System.out.println(arg);
            if(arg instanceof Account){
                Account account = (Account) arg;
                System.out.println("Account Name: "+ account.getName());
                System.out.println("Account Level: "+ account.getLevel());
            }
        }

    }

}