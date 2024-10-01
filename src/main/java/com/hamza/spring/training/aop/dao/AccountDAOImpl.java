package com.hamza.spring.training.aop.dao;


import com.hamza.spring.training.aop.Account;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {

        List<Account> myAccounts = new ArrayList<>();

        // create samples accounts
        Account account1 = new Account("Hamza","Silver");
        Account account2 = new Account("Hanan","Gold");
        Account account3 = new Account("Rayhan","Platinum");

        myAccounts.add(account1);
        myAccounts.add(account2);
        myAccounts.add(account3);

        System.out.println("before returing");

        return myAccounts;
    }

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");

    }

    @Override
    public boolean doWork() {

        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
