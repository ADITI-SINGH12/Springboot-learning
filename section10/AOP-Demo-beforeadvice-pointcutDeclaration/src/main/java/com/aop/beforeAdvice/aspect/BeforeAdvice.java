package com.aop.beforeAdvice.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeAdvice {
    @Pointcut("execution(public void com.aop.beforeAdvice.dao.*.add*())")
    private void fordaoDemo(){}
    @Before("fordaoDemo()")
    void beforeAdviceAspect(){
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }

    @Before("fordaoDemo()")
    void piAnalytics(){
        System.out.println("=====>>> Executing @Before advice on API Analytics");
    }
}
