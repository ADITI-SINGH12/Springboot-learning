package com.luv2code.springboot.thymeleafdemo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {
    //set up logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAPIFlows(){}

    @Before("forAPIFlows()")
    public void beforeDemoLogin(JoinPoint joinPoint){
        //display name of the method calling
        String themethod = joinPoint.getSignature().toShortString();
        myLogger.info("=====>> in @Before: calling method: "+ themethod);
        //display arguments to the method
        Object args[] = joinPoint.getArgs();
        for(Object arg : args){
            myLogger.info("=====>> in @Before: calling arguments: "+ arg);
        }

    }

    @AfterReturning( pointcut = "forAPIFlows()",returning = "theresult")
    public void afterDemoLogin(JoinPoint joinPoint,Object theresult) {
        //display name of the method calling
        String themethod = joinPoint.getSignature().toShortString();
        myLogger.info("=====>> in @AfterReturning: calling method: "+ themethod);
        //display arguments to the method
        myLogger.info("=====>> result: " + theresult);
    }
}
