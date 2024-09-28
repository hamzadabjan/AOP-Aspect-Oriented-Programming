package com.hamza.spring.training.aop.dao;


import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{


    @Override
    public boolean addAccount() {
        System.out.println(getClass() +": "+ "Doing My DB Work: Adding A Membership Account");

        return true;
    }
}
