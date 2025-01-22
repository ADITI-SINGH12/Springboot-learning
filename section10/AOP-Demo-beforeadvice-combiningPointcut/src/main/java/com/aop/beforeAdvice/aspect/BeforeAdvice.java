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

    @Pointcut("execution(public void com.aop.beforeAdvice.dao.*.get*())")
    private void getter(){}

    @Pointcut("execution(public void com.aop.beforeAdvice.dao.*.set*())")
    private void setter(){}

    @Pointcut("fordaoDemo() && !(getter() || setter())")
    private void fordaoDemoExcludeGetterSetter(){}

    @Before("fordaoDemoExcludeGetterSetter()")
    void beforeAdviceAspect(){
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }

//    @Before("fordaoDemo()")
//    void piAnalytics(){
//        System.out.println("=====>>> Executing @Before advice on API Analytics");
//    }
}
