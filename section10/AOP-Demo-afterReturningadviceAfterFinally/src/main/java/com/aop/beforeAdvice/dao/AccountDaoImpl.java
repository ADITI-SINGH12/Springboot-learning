package com.aop.beforeAdvice.dao;

import com.aop.beforeAdvice.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao{
    @Override
    public void addAccount() {
        System.out.println("Account is added to DB");
    }

    @Override
    public List<Account> listAccounts() {
     return findAccount(false);
    }

    @Override
    public List<Account> findAccount(boolean theTripWire) {
        if(theTripWire == true){
            throw new RuntimeException("No soup for you!!!");
        }
        List<Account> theAccounts = new ArrayList<>();
        Account temp1 = new Account("Aditi","Level1");
        Account temp2 = new Account("Astha","Level2");
        Account temp3 = new Account("Akshansh","Level3");
        theAccounts.add(temp1);
        theAccounts.add(temp2);
        theAccounts.add(temp3);
        return theAccounts;
    }
}
