package com.aop.beforeAdvice.dao;

import org.springframework.stereotype.Repository;


public interface AccountDao {
    void addAccount();
    public String getName();
    public void setName(String name);
    public String getService();
    public void setService(String service);
}
