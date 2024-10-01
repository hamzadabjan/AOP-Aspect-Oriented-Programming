package com.hamza.spring.training.aop.aspect;


import com.hamza.spring.training.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class MyLoggingAspect {

    // add new advice for @AfterReturning on the findAccounts method

    @AfterReturning(
            pointcut = "execution(* com.hamza.spring.training.aop.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void AfterReturningfindAccountsAdvice(JoinPoint joinPoint, List<Account> result){

        System.out.println("This Advice will Execute after: " + joinPoint.getSignature().toShortString());
        System.out.println("Returning value is:"+result);

        // Let's modify result
        convertAccountsNamesToUppercase(result);
        System.out.println("Returning value is:"+result);

    }

    private void convertAccountsNamesToUppercase(List<Account> result) {

        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }

    // This is where we add all of our related advices for logging
    @Pointcut("execution(* com.hamza.spring.training.aop.dao.*.*(..))")
    public void forDaoPackage() {}

    // create a pointcut for getter methods
    @Pointcut("execution(* com.hamza.spring.training.aop.dao.*.get*(..))")
    public void getter() {}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.hamza.spring.training.aop.dao.*.set*(..))")
    public void setter() {}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

}
