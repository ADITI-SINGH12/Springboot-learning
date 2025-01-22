package com.aop.beforeAdvice.aspect;

import com.aop.beforeAdvice.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class BeforeAdvice {

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

    @AfterReturning(value = "execution(* com.aop.beforeAdvice.dao.AccountDao.listAccounts(..))",
            returning = "accountList")
    void afterReturningAfterAdvice(JoinPoint theJoinPoint, List<Account> accountList){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After advice on "+ method);
     //   System.out.println("\n=====>>> Executing @After advice on addAccount()");
        System.out.println("\\n=====>>> After advice "+accountList);
    }
    @Before("execution(public void com.aop.beforeAdvice.dao.*.add*())")
    void beforeAdviceAspect(){
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }
}
