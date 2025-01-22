package com.aop.beforeAdvice.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{
    private String name;
    private String service;
    @Override
    public void addAccount() {
        System.out.println("Account is added to DB");
    }

    @Override
    public String getName() {
        System.out.println(getClass()+" its work get name");
        return name;
    }
    @Override
    public void setName(String name) {
        System.out.println(getClass()+" its work set name");
        this.name = name;
    }
    @Override
    public String getService() {
        System.out.println(getClass()+" its work get service");
        return service;
    }

    @Override
    public void setService(String service) {
        System.out.println(getClass()+" its work set service");
        this.service = service;
    }

}
