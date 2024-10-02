package com.hamza.spring.training.aop.aspect;


import com.hamza.spring.training.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class MyLoggingAspect {


    @Around("execution(* com.hamza.spring.training.aop.service.TrafficFortuneServiceImpl.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n ======>>> Executing @After (finally) on method: "+method);

        long begin = System.currentTimeMillis();

        Object result = theProceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        long duration = end - begin;

        System.out.println("\n ======>> Duration: "+duration/1000.0 +"seconds");

        return result;
    }



    // add new advice for @AfterThrowing on the findAccount method
    @AfterThrowing(
            pointcut = "execution(* com.hamza.spring.training.aop.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void AfterThrowingfindAccountsAdvice(JoinPoint joinPoint, Throwable theExc){
        System.out.println("Exception name: "+ theExc);
    }


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
