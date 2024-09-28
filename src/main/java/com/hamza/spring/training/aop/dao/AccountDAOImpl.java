package com.hamza.spring.training.aop.dao;


import com.hamza.spring.training.aop.Account;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{


    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass() +": "+ "Doing My DB Work: Adding An Account");
    }
}
