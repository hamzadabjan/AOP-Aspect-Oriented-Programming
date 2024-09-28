package com.hamza.spring.training.aop.dao;

import com.hamza.spring.training.aop.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);

}
