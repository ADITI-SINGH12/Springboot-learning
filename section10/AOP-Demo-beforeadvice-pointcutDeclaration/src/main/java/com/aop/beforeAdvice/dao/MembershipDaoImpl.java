package com.aop.beforeAdvice.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements  MembershipDao{
    @Override
    public void addAccount() {
        System.out.println("Adding account in membership DB");
    }
}
