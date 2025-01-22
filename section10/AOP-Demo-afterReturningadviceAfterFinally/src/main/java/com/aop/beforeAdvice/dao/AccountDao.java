package com.aop.beforeAdvice.dao;

import com.aop.beforeAdvice.Account;

import java.util.List;


public interface AccountDao {
    void addAccount();
    List<Account> listAccounts();
    List<Account> findAccount(boolean theTripWire);
}
