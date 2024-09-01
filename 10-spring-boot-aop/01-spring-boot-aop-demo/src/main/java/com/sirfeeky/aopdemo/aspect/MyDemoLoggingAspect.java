package com.sirfeeky.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging

    @Before("execution(public void com.sirfeeky.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======>>>> Executing @Befrore advice on addAccount\n");
    }

    @After("execution(public void add*())")
    public void afterAddAccountAdvice() {
        System.out.println("\n======>>>> Executing @After advice on addAccount\n");
    }

     @Before("execution(public void updateAccount())")
    public void beforeUpdateAccountAdvice() {
        System.out.println("\n======>>>> Executing @Befrore advice on updateAccount\n");
    }
}
