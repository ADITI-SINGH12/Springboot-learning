package com.aop.beforeAdvice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class BeforeAdvice {


    //Around advice
    @Around(value = "execution(* com.aop.beforeAdvice.service.FortuneService.getFortuneService(..))")
    Object demoAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @Around Advice on method: "+method);
        long start = System.currentTimeMillis();
       Object result =  proceedingJoinPoint.proceed();
       long end =  System.currentTimeMillis();

        // compute duration and display it
        long duration = end - start;
        System.out.println("\n=====> Duration: " + duration / 1000.0 + " seconds");

        return result;

    }

    @After(value = "execution(* com.aop.beforeAdvice.dao.AccountDao.findAccount(..))")
    void afterFinallyAdvice(JoinPoint joinPoint){
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After (finally) on method: " + method);
    }
    @AfterThrowing(value = "execution(* com.aop.beforeAdvice.dao.AccountDao.findAccount(..))",
            throwing="exc")
    void afterThrowingAdvice(JoinPoint joinPoint,Throwable exc){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n=====>>> The exception is: " + exc);
    }


}
