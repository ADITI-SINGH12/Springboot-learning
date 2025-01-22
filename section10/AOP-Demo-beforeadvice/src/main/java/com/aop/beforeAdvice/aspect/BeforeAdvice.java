package com.aop.beforeAdvice.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeAdvice {
    @Before("execution(public void com.aop.beforeAdvice.dao.*.add*())")
    void beforeAdviceAspect(){
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }
}
